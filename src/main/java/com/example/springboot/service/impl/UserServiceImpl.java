package com.example.springboot.service.impl;

import com.example.springboot.config.JwtConfig;
import com.example.springboot.dao.UserDao;
import com.example.springboot.entity.User;
import com.example.springboot.service.RedisService;
import com.example.springboot.service.UserService;
import com.example.springboot.utils.CODE;
import com.example.springboot.utils.PageUtils;
import com.example.springboot.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JwtConfig jwtConfig;
    @Autowired
    private UserDao userDao;
    @Autowired
    private RedisService redisService;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public Result regist(User user) {
        //1.判断一下必填项
        //2.判断手机账号是否存在
        //3.验证码验证，
        //4.发送短信验证码
        User username = this.userDao.getByMobile(user.getMobile());

        if(username != null){
            return Result.error("用户已存在");
        }
        user.setUsername(user.getMobile());
        user = this.userDao.save(user);
        return Result.success(user);
    }

    @Override
    public Result getById(Integer id) {
        User user = userDao.findById(id).get();//根据id查询用户;
        return Result.success(user);
    }

    @Override
    public Result update(User user) {
        user = this.userDao.save(user);
        return Result.success("修改成功");

    }

    @Override
    public Result delete(Integer id) {

        this.userDao.deleteById(id);
        return Result.success("删除成功");
    }

    @Override
    public Page<User> findBookNoCriteria(Integer page, Integer size) {
        return null;
    }

    @Override
    public Page<User> findBookCriteria(Integer page, Integer size, User user) {
        return null;
    }

    @Override
    public PageUtils findAll(Pageable pageable) {
        Page<User> page =userDao.findAll(pageable);
        PageUtils result = new PageUtils(page.getNumber(),page.getSize(),page.getTotalElements(),page.getTotalPages(),page.getContent());
        return result;
    }


    @Override
    public Result login(String username, String password) {
        User user = this.userDao.getByUsername(username);
        if(user==null){
            return Result.error("用户名不存在");
        }
        if(!password.equals(user.getPassword())){
           return Result.error("密码错误");
        }

        String token = jwtConfig.createToken(username);


        return Result.success(token);
    }

    @Override
    public Result loginVerify(String mobile, String code) {

        //1.拼接redis中的key字符串
        String joint= CODE.VIRIFY_LOGIN +"_" +mobile;
        // 获取到 redis中的value
        String moblieVerifyKey = redisService.getValueByKey(joint);
        // 获取 redis的value,就是验证码
        if(moblieVerifyKey == null){
            return Result.error("手机验证码已过期！");
        }
        if(!code.equals(moblieVerifyKey)){
            return Result.error("手机验证码出错！");
        }
        redisService.delete(joint);
        //，接口实现手机号和短信验证码，把手机号拼接成redis中key,
        String token = jwtConfig.createToken(mobile);


        return Result.success(token);
    }


    @Override
    public Result sendMessage(String mobile, Integer type) {
        //1.校验手机号
        if(type == CODE.VIRIFY_LOGIN){
            User user = userDao.getByMobile(mobile);
            if(user == null){
                return Result.error("该手机号未注册");
            }
        }

        //2.生成验证码 ，生成4位随机数
        String str="0123456789";
        StringBuilder code=new StringBuilder(4);
        for(int i=0;i<4;i++)
        {
//public int nextInt(int n) 该方法的作用是生成一个随机的int值，该值介于[0,n)的区间，也就是0到n之间的随机int值，包含0而不包含n。
            char ch=str.charAt(new Random().nextInt(str.length()));
            code.append(ch);

        }
        System.out.println(code.toString());

        //3.发送短信



        //4.保存redis
        redisService.addKey(type+"_"+mobile,code.toString(),60*5);

        return Result.success("");
    }
}
