package com.example.springboot.dao;

import com.example.springboot.entity.Book;
import com.example.springboot.entity.Images;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagesDao extends JpaRepository<Images,Integer> {

}
