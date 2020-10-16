package com.example.springboot.service;

import com.example.springboot.Vo.BooksVo;
import com.example.springboot.entity.BooksClass;

import java.util.List;

public interface BooksClassService {
    public List<BooksClass> selectBooksClass(Integer id);
    List<BooksVo> selectBooksVo();

}
