package com.example.springboot.service;

import com.example.springboot.Vo.BookOrderVo;
import com.example.springboot.entity.BookOrder;
import com.example.springboot.utils.Result;

import java.util.List;

public interface OrderService{

    public List<BookOrder> findAll();

    //List<BookOrder> findByProNameLike(String proName);
    public Result getById(Integer id);
    //public Result getByProName(String proName);
    Result insert(BookOrderVo bookOrderVo);
    public Result delete(Integer id);
    public Result update(BookOrder bookOrder);
//    Page<BookOrder> findAll(Integer page, Integer pageSize);//分页查询


}
