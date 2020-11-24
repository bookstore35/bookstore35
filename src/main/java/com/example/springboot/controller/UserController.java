package com.example.springboot.controller;

import com.example.springboot.aop.UserLoginToken;

import com.example.springboot.entity.User;
import com.example.springboot.service.RedisService;
import com.example.springboot.service.UserService;

import com.example.springboot.utils.CodeUtil;
import com.example.springboot.utils.PageUtils;
import com.example.springboot.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户管理
 *
 * @author yifeng
 * @return
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private CodeUtil codeUtil;
    @Autowired
    private UserService userService;
    @Autowired
    private RedisService redisService;

    /**
     * 登录接口
     * @param username  用户名
     * @param password  密码
     * @return
     *
     */
    @GetMapping("/login")
    public Result<User>  login(String username , String password , HttpServletRequest request){
        return userService.login(username ,password);
    }

    /**
     *
     * @param user
     * @param request
     * @return
     */
    @PostMapping("/regist")
    public Result<User>  regist(@RequestBody User user,HttpServletRequest request){

//        try {
//            if (!codeUtil.checkVerifyCode(request)) {
//                return Result.error("验证码出错");
//            }
//        } catch (Exception e) {
//            // 返回错误信息给前端
//            return Result.error(e.getMessage());
//        }
        return this.userService. regist(user);
    }
    /**
     * 校验验证码的接口
     *
     */
    @GetMapping("/checkVerify")
    public Result<User> checkVerfiy(@RequestParam String verifyCodeInput, HttpServletRequest request){
        String id = request.getSession().getId();
        // redis保存的验证码
        String verifyCodeExpected = redisService.getValueByKey(id);
        if(verifyCodeExpected == null){
            return Result.error("验证码已过期！");
        }

        //2-1.获取用户输入的验证码---验证码的值verifyCodeInput
        String inputStr =  verifyCodeInput;

        //3.判断逻辑
        if(inputStr == null){
            return Result.error("验证码为空！");
        }
        if(!inputStr.equals(verifyCodeExpected)) {
            return Result.error("验证码错误！");
        }
        return Result.success("验证成功");
    }
    /**
     * 查询所有用户接口
     * @return
     */
    @GetMapping("/findAll")
    public Result<User> findAll(){
        return Result.success(userService.findAll());
    }
    /**
     * 根据id查询用户接口
     *
     * @return
     */
    @UserLoginToken
    @GetMapping("/getById")
    public Result<User>  getById(Integer id){

        return userService.getById(id);
    }
    /**
     * 修改用户接口
     * @param user
     * @return
     */
    @PostMapping("/update")
    public Result<User> update(@RequestBody User user ){

        return this.userService.update(user);
}

    /**
     * 删除用户接口
     *
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public Result<User> delete(@PathVariable("id") Integer id ){
        return this.userService.delete(id);
    }

    /**
     * 手机登录发送验证码接口
     *
     * @return
     */
    @GetMapping("/loginVerify")
    public Result<User>  loginVerify(String moblie , String code , HttpServletRequest request){

        return userService.loginVerify(moblie ,code);
    }

    /**
     * 发送短信验证码接口
     * @param tel 手机号
     * @param type 短信类型：0 注册， 1 登录
     * @return
     */
    @GetMapping("/send")
    public Result sendMessage(String tel , Integer type){

        //type_tel :key
        return userService.sendMessage(tel,type);
    }

    /**
     * 分页查询接口qqqq
     * @param pageNo  第几页
     * @param pageSize 多少记录
     * @return
     */
    @GetMapping("/page")
    private Result<PageUtils<User>> page(@RequestParam("pageNo")Integer pageNo, @RequestParam("pageSize")Integer pageSize){
        Pageable pageable = PageRequest.of(pageNo,pageSize);
          //pageNo从第几页开始查，pageSize页面条数
        return  Result.success(userService.findAll(pageable));
    }


}
