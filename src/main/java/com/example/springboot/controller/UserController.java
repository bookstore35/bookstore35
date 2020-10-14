package com.example.springboot.controller;

import com.example.springboot.aop.UserLoginToken;
import com.example.springboot.entity.BooksClass;
import com.example.springboot.entity.User;
import com.example.springboot.service.UserService;
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
    public Result<User> regist(@RequestBody User user){
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
        if (!codeUtil.checkVerifyCode(request)) {
            return Result.error("验证码出错");
        }
        return userService.login(username ,password);
    }
    @GetMapping
    @RequestMapping("/send")
    public Result sendMessage(String tel , Integer type){
        return null;
    }

}
