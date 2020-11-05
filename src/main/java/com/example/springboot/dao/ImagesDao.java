package com.example.springboot.dao;

import com.example.springboot.entity.Book;
import com.example.springboot.entity.Images;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ImagesDao extends JpaRepository<Images,Integer> {
    /*List<Images> findByBid(int Bid);*/

    void deleteByBid(int Bid);

    @Modifying
    @Transactional
    @Query(value = "delete book,images from  book left join  images on book.id = images.bid where book.id= ?",nativeQuery = true)
    void deleteBook(Integer id);

}
