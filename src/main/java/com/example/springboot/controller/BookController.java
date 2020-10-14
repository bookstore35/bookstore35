package com.example.springboot.controller;

import com.example.springboot.entity.Book;
import com.example.springboot.service.BookService;
import com.example.springboot.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 书籍管理接口类
 */
@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;


    /**
     * 查找全部书本
     * @return
     */
    @GetMapping("/findAll")
    public Result<Book> findAll(){
        return Result.success(bookService.findAll());
    }

    /**
     * 查询全部（书本内容+书本级别分类）
     * @return
     */
    @GetMapping("/selectAll")
    public Result<Book> selectAll(){
        return Result.success(bookService.selectALl());
    }

    /**
     * 书名模糊查询
     * @param bookName
     * @return
     */
    @GetMapping("/getBookNameLike/{bookName}")
    public Result<Book> getBookNameLike(@PathVariable("bookName") String bookName){
        List<Book> books = bookService.findByBookNameLike(bookName);
        return Result.success(books);
    }

    /**
     * 根据id查询书本信息
     * @param id
     * @return
     */
    @GetMapping
    @RequestMapping("/getById")
    public Result<Book> getById(Integer id){
        return bookService.getById(id);
    }

    /**
     * 根据书名查询书本信息
     * @param bookName
     * @return
     */
    @GetMapping
    @RequestMapping("/getByBookName")
    public Result<Book> getByBookName(String bookName){
        return bookService.getByBookName(bookName);
    }


    /**
     * 添加书本信息
     * @param book
     * @return
     */
    @PostMapping
    @RequestMapping("/insert")
    public Result<Book> insert(@RequestBody Book book) {
        return this.bookService.insert(book);
    }

    /**
     * 修改书本信息
     * @param book
     * @return
     */
    @PostMapping
    @RequestMapping("/update")
    public Result<Book> update(@RequestBody Book book){
        return this.bookService.update(book);
    }

    /**
     * 删除书本
     * @param id
     * @return
     */
    @DeleteMapping
    @RequestMapping("/delete")
    public Result<Book> deleteById(Integer id){
        return this.bookService.delete(id);
    }
    // Result<Book>--data里面的数据类型是什么<>里面就放什么 例如：<Book>

}
