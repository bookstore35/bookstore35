package com.example.springboot.dao;


import com.example.springboot.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartDao extends JpaRepository<ShoppingCart,Integer> {


}
