package com.example.springboot.controller;


import com.example.springboot.Vo.BooksVo;
import com.example.springboot.Vo.IndexVo;
import com.example.springboot.aop.UserLoginToken;
import com.example.springboot.entity.Book;
import com.example.springboot.entity.Seller;
import com.example.springboot.service.BookService;
import com.example.springboot.service.RedisService;
import com.example.springboot.service.SellerService;
import com.example.springboot.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 书籍管理接口类
 */
@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private SellerService sellerService;
    @Autowired
    private RedisService redisService;


    /**
     * 查找全部书本
     * @return
     */
    @GetMapping("/findAll")
    public Result<Book> findAll(){

        return Result.success(bookService.findAll());
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
    @GetMapping("/getById")
    public Result<BooksVo> getById(Integer id){

        return Result.success(bookService.getById(id));
    }

    /**
     * 根据书名查询书本信息
     * @param bookName
     * @return
     */
    @GetMapping("/getByBookName")
    public Result<Book> getByBookName(String bookName){
        return bookService.getByBookName(bookName);
    }


    /**
     * 添加书本信息
     * @param vo
     * @param request
     * @return
     */
    @UserLoginToken
    @PostMapping("/insert")
    public Result<BooksVo> insert(@RequestBody BooksVo vo , HttpServletRequest request) {
        String userName = request.getAttribute("identityId").toString();
        Seller seller = sellerService.getByUserName(userName);
        vo.setSid(seller.getId());
        return this.bookService.insert(vo);
    }


    /**
     * 修改书本信息
     * @param vo
     * @return
     */
    @PostMapping("/update")
    public Result<BooksVo> update(@RequestBody BooksVo vo){
        return this.bookService.update(vo);
    }

    /**
     * 删除书本
     * @param id
     * @return
     */
    @DeleteMapping("/delete")
    public Result<BooksVo> deleteById(Integer id){
        return this.bookService.delete(id);
    }
    // Result<Book>--data里面的数据类型是什么<>里面就放什么 例如：<Book>

    /**
     * 分页显示所有
     * @param pageNo
     * @param pageSize
     * @param response
     * @return
     */
    @GetMapping("/pageFindAll")
    public Result<Page<Book>> PageFindAll(Integer pageNo,Integer pageSize, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin","*");//解决跨域请求

        /*if(page==null || page<=0){
            page = 0;
        }else{
            page -= 1;
        }
        if(limit==null||limit<=5){
            limit=5;
        }*/
        Page<Book> pageData=bookService.findAll(pageNo,pageSize);
//        request.setAttribute("stu", pageData);
        return Result.success(pageData);
    }


    /**
     * 首页接口
     * @return
     */

    @GetMapping("/index")
    public Result<IndexVo> index(){
        return Result.success(bookService.index());
    }


}