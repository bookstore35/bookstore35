package com.example.springboot.service;


import com.example.springboot.entity.Book;
import com.example.springboot.utils.Result;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BookService {
    List<Book> findAll();
    List<Book> findByBookNameLike(String bookName);
    public Result getById(Integer id);
    public Result getByBookName(String bookName);
    public Result insert(Book book);
    public Result delete(Integer id);
    public Result update(Book book);
    Page<Book> findAll(int page, int pageSize);//分页查询
}
