package com.example.springboot.dao;

import com.example.springboot.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SellerDao extends JpaRepository<Seller,Integer> {
    List<Seller> findAll();
}
