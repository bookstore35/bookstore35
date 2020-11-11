package com.example.springboot.service;



import com.example.springboot.Vo.BooksClassVo;
import com.example.springboot.Vo.BooksVo;
import com.example.springboot.Vo.IndexVo;
import com.example.springboot.entity.Book;
import com.example.springboot.utils.Result;
import org.springframework.data.domain.Page;

import javax.persistence.Index;
import java.util.List;

public interface BookService {
    List<Book> findAll();
    List<Book> findByBookNameLike(String bookName);
    public Result getByBookName(String bookName);
    public Result insert(BooksVo vo);
    Result delete(Integer id);
    public Result update(BooksVo vo);
    Page<Book> findAll(Integer pageNo,Integer pageSize);//分页查询
    BooksVo getById(Integer id);
    IndexVo index();

}
