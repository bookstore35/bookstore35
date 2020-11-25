package com.example.springboot.dao;

import com.example.springboot.entity.OrderDetail;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface OrderDetailDao extends JpaRepository<OrderDetail,Integer> {

	List<OrderDetail> findAll();

	Page<OrderDetail> findAll(Pageable pageable);

	List<OrderDetail> findByBookNameLike(String bookName);

	public OrderDetail findByBookName(String bookName);



}
