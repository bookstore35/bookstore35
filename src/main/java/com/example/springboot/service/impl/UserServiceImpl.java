package com.example.springboot.service.impl;

import com.example.springboot.dao.UserDao;
import com.example.springboot.entity.User;
import com.example.springboot.service.UserService;
import com.example.springboot.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public Result regist(User user) {
        //1.判断一下必填项
        //2.判断账号是否存在
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
}
