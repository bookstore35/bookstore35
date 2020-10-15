package com.example.springboot.controller;

import com.example.springboot.aop.UserLoginToken;
import com.example.springboot.entity.BooksClass;
import com.example.springboot.entity.User;
import com.example.springboot.service.UserService;
import com.example.springboot.service.impl.UserServiceImpl;
import com.example.springboot.utils.CodeUtil;
import com.example.springboot.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private CodeUtil codeUtil;
    @Autowired
    private UserService userService;


    /**
     * 注册接口
     * @param user
     * @return
     */
    @PostMapping
    @RequestMapping("/regist")
    public Result<User>  regist(@RequestBody User user,HttpServletRequest request){
        try {
            if (!codeUtil.checkVerifyCode(request)) {
                return Result.error("验证码出错");
            }
        } catch (Exception e) {
            // 返回错误信息给前端
            return Result.error(e.getMessage());
        }
        return this.userService. regist(user);
    }

    @UserLoginToken
    @GetMapping
    @RequestMapping("/getById")
    public Result<User>  getById(Integer id){

        return userService.getById(id);
    }



    @GetMapping
    @RequestMapping("/login")
    public Result<User>  login(String username , String password , HttpServletRequest request){
  /*      try {
            if (!codeUtil.checkVerifyCode(request)) {
                return Result.error("验证码出错");
            }
        } catch (Exception e) {
            // 返回错误信息给前端
            return Result.error(e.getMessage());
        }*/
        return userService.login(username ,password);
    }
    @GetMapping
    @RequestMapping("/loginVerify")
    public Result<User>  loginVerify(String moblie , String code , HttpServletRequest request){

        return userService.loginVerify(moblie ,code);
    }

    /**
     *
     * @param tel 手机号
     * @param type 短信类型：0 注册， 1 登录
     * @return
     */
    @GetMapping
    @RequestMapping("/send")
    public Result sendMessage(String tel , Integer type){

        //type_tel :key
        return userService.sendMessage(tel,type);
    }



}
