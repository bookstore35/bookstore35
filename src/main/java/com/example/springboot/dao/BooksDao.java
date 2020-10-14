package com.example.springboot.dao;

import com.example.springboot.entity.Books;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksDao extends CrudRepository<Books,String> {
    @Query(value = "select * from  book left join books_class on book.cid=books_class.id ", nativeQuery = true)
    public List<Books> countDeviceInfoByCondition3();
}
