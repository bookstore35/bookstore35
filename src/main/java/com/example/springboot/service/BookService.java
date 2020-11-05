package com.example.springboot.service;



import com.example.springboot.Vo.ImagesVo;
import com.example.springboot.entity.Book;
import com.example.springboot.entity.Images;
import com.example.springboot.utils.Result;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BookService {
    List<Book> findAll();
    List<Book> findByBookNameLike(String bookName);
    public Result getById(Integer id);
    public Result getByBookName(String bookName);
    public Result insert(ImagesVo vo);
    Result delete(Integer id);
    public Result update(ImagesVo vo);
    Page<Book> findAll(Integer page, Integer pageSize);//分页查询

}
