package com.example.springboot.service;

import com.example.springboot.entity.OrderDetail;
import com.example.springboot.utils.Result;

import java.util.List;

public interface OrderDeService {

    public List<OrderDetail> findAll();

    public Result getById(Integer id);
    public Result insert(OrderDetail orderDetail);
    public Result delete(Integer id);
    Result<OrderDetail> update(OrderDetail orderDetail);

}
