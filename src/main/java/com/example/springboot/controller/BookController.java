package com.example.springboot.controller;

import com.example.springboot.entity.Book;
import com.example.springboot.service.BookService;
import com.example.springboot.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/findAll")
    public List<Book> findAll(){
        return bookService.findAll();
    }
    @GetMapping
    @RequestMapping("/getById")
    public Result getById(Integer id){
        return bookService.getById(id);
    }
    @GetMapping
    @RequestMapping("/getByBookName")
    public Result getByBookName(String bookName){
        return bookService.getByBookName(bookName);
    }


    @PostMapping
    @RequestMapping("/insert")
    public Result insert(@RequestBody Book book) {
        return this.bookService.insert(book);
    }

}
