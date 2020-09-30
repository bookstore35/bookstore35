package com.example.springboot.controller;


import com.example.springboot.entity.BooksClass;
import com.example.springboot.service.BooksClassService;
import com.example.springboot.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 书本分类查询接口
 */
@RestController
public class BooksClassController {
    @Autowired
    private BooksClassService booksClassService;

    @GetMapping
    @RequestMapping("/booksClass")
    public Result selectBooksClass(Integer id){

        return Result.success(booksClassService.selectBooksClass(id));
    }

}
