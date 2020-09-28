package com.example.springboot.controller;

import com.example.springboot.aop.UserLoginToken;
import com.example.springboot.entity.User;
import com.example.springboot.service.UserService;
import com.example.springboot.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 注册接口
     * @param user
     * @return
     */
    @PostMapping
    @RequestMapping("/regist")
    public Result regist(@RequestBody User user){
        return this.userService. regist(user);
    }

    @UserLoginToken
    @GetMapping
    @RequestMapping("/getById")
    public Result getById(Integer id){
        return userService.getById(id);
    }

    @GetMapping
    @RequestMapping("/login")
    public Result login(String username ,String password){

        return userService.login(username ,password);
    }
    @GetMapping
    @RequestMapping("/send")
    public Result sendMessage(String tel , Integer type){
        return null;
    }

}
