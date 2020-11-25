package com.example.springboot.dao;

import com.example.springboot.entity.BookOrder;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface OrderDao extends JpaRepository<BookOrder,Integer> {

	List<BookOrder> findAll();

	Page<BookOrder> findAll(Pageable pageable);

//	List<BookOrder> findByProNameLike(String proName);
//
//	public BookOrder findByProName(String proName);

}
