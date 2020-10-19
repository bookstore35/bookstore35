package com.example.springboot.service;

import com.example.springboot.entity.Seller;
import com.example.springboot.utils.Result;

import java.util.List;

public interface SellerService {
    List<Seller> findAll();
    public Result insert(Seller seller);
    public Result delete(Integer id);
    public Result update(Seller seller);

    public Result login(String username,String password );
}
