package com.example.springboot.service;

import com.example.springboot.entity.User;
import com.example.springboot.utils.Result;

public interface UserService {
    /**
     * 注册方法
     * @param user
     * @return
     */
    public Result regist(User user);

    public Result getById(Integer id);


    //手机号、密码登录接口
    public Result login(String username,String password );

    //手机验证码登录接口
    public Result loginVerify(String mobile,String code);
    //
    public Result sendMessage(String tel ,Integer type);
}
