package com.example.springboot.service;

import com.example.springboot.Vo.BooksVo;
import com.example.springboot.entity.BooksClass;
import com.example.springboot.utils.Result;

import java.util.List;

public interface BooksClassService {
    public List<BooksClass> selectBooksClass(Integer id);
    List<BooksVo> selectBooksVo(Integer number,Integer content);
    List<BooksClass> findAll();
    public Result insert(BooksClass booksClass);
    public Result delete(Integer id);
    public Result update(BooksClass booksClass);
    List<BooksClass> listWithTree();

}
