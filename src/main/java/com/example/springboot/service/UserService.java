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

}
