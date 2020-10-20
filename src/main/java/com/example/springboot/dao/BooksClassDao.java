package com.example.springboot.dao;

import com.example.springboot.entity.BooksClass;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BooksClassDao extends JpaRepository<BooksClass,Integer> {
    List<BooksClass> findAll();
    BooksClass findByName(String Name);


}
