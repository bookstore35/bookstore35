package com.example.springboot.dao;

import com.example.springboot.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookDao extends JpaRepository<Book,Integer> {
    List<Book> findAll();

    public Book findByBookName(String bookName);


}
