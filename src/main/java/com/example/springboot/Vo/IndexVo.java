package com.example.springboot.Vo;

import com.example.springboot.entity.Advertise;
import com.example.springboot.entity.Book;
import com.example.springboot.entity.BooksClass;
import org.springframework.data.domain.Page;

import java.util.List;

public class IndexVo {
    private Page<Book> bookList;    //书本列表 page类
    private List<BooksClass> booksClassList;    //书本分类列表
    private List<Advertise> advertiseList;      //广告列表

    public Page<Book> getBookList() {
        return bookList;
    }

    public void setBookList(Page<Book> bookList) {
        this.bookList = bookList;
    }

    public List<BooksClass> getBooksClassList() {
        return booksClassList;
    }

    public void setBooksClassList(List<BooksClass> booksClassList) {
        this.booksClassList = booksClassList;
    }

    public List<Advertise> getAdvertiseList() {
        return advertiseList;
    }

    public void setAdvertiseList(List<Advertise> advertiseList) {
        this.advertiseList = advertiseList;
    }
}
