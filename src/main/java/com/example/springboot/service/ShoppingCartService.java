package com.example.springboot.service;

import com.example.springboot.Vo.ShoppingCartVo;
import com.example.springboot.entity.ShoppingCart;
import com.example.springboot.entity.User;
import com.example.springboot.utils.Result;

import java.util.List;

public interface ShoppingCartService {

     public Result getById(Integer id);
     public Result insert(ShoppingCart shoppingCart);
     public Result delete(Integer id);
     public Result update(ShoppingCart shoppingCart);
     User findAllByUsername(String userName);
     List<ShoppingCartVo> selectCart(Integer uid);

}
