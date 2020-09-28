package com.example.springboot.service.impl;

import com.example.springboot.config.JwtConfig;
import com.example.springboot.dao.UserDao;
import com.example.springboot.entity.User;
import com.example.springboot.service.UserService;
import com.example.springboot.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JwtConfig jwtConfig;
    @Autowired
    private UserDao userDao;
    @Override
    public Result regist(User user) {
        //1.判断一下必填项
        //2.判断手机账号是否存在
        //3.
        User old = this.userDao.getByUsername(user.getUsername());

        if(old != null){
            return Result.error("用户已存在");
        }
        user = this.userDao.save(user);
        return Result.success(user);
    }

    @Override
    public Result getById(Integer id) {
        User user = userDao.findById(id).get();//根据id查询用户;
        return Result.success(user);
    }

    @Override
    public Result login(String username, String password) {
        //1.
        //2.
        //3.
        User user = this.userDao.getByUsername(username);
        if(user==null){
            return Result.error("用户名不存在");
        }
        if(!password.equals(user.getPassword())){
           return Result.error("密码错误");
        }
//        Instant now = Instant.now();
//        String secretKey = jwtConfig.getSecret();
        String token = jwtConfig.createToken(username);


        return Result.success(token);
    }


    @Override
    public Result sendMessage(String tel, Integer type) {
        //1.生成验证码
        //2.发送短信
        //3.保存redis
        return null;
    }
}
