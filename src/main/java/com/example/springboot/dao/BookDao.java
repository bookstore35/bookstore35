package com.example.springboot.dao;

import com.example.springboot.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
public interface BookDao extends JpaRepository<Book,Integer> {
    List<Book> findAll();

    Page<Book> findAll(Pageable pageable);

    List<Book> findByBookNameLike(String bookName);

    public Book findByBookName(String bookName);

    @Modifying
    @Transactional
    @Query(value = "delete book,images from  book left join  images on book.id = images.bid where book.id= ?",nativeQuery = true)
    void deleteBook(Integer id);





}
