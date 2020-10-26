package com.example.springboot.service;

import com.example.springboot.entity.User;
import com.example.springboot.utils.PageUtils;
import com.example.springboot.utils.Result;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    /**
     * 注册方法
     * @param user
     * @return
     */
    List<User> findAll();
    public Result regist(User user);
    public Result getById(Integer id);
    public Result update(User user);
    public Result delete(Integer id);
    Page<User> findBookNoCriteria(Integer page, Integer size);
    Page<User> findBookCriteria(Integer page,Integer size,User user);
    //用户查询
    PageUtils findAll(Pageable pageable);



    //手机号、密码登录接口
    public Result login(String username,String password );

    //手机验证码登录接口
    public Result loginVerify(String mobile,String code);
    //
    public Result sendMessage(String tel ,Integer type);
}
