package com.example.springboot.controller;

import com.example.springboot.Vo.ImagesVo;
import com.example.springboot.entity.Book;
import com.example.springboot.service.BookService;
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
    public Result<Book> getById(Integer id){
        return bookService.getById(id);
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
     * @param
     * @return
     */
    @PostMapping("/insert")
    public Result<Book> insert(@RequestBody ImagesVo imagesVo) {
        return this.bookService.insert(imagesVo);
    }

    /**
     * 修改书本信息
     * @param book
     * @return
     */
    @PostMapping("/update")
    public Result<Book> update(@RequestBody Book book){
        return this.bookService.update(book);
    }

    /**
     * 删除书本
     * @param id
     * @return
     */
    @DeleteMapping("/delete")
    public Result<Book> deleteById(Integer id){
        return this.bookService.delete(id);
    }
    // Result<Book>--data里面的数据类型是什么<>里面就放什么 例如：<Book>

    /**
     * 分页显示所有
     * @param page
     * @param limit
     * @param response
     * @return
     */
    @GetMapping("/pageFindAll")
    public Result<Page<Book>> PageFindAll(Integer page,Integer limit, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin","*");//解决跨域请求

        /*if(page==null || page<=0){
            page = 0;
        }else{
            page -= 1;
        }
        if(limit==null||limit<=5){
            limit=5;
        }*/
        Page<Book> pageData=bookService.findAll(page,limit);
//        request.setAttribute("stu", pageData);
        return Result.success(pageData);
    }
}
