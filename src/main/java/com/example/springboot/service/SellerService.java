package com.example.springboot.service;

import com.example.springboot.entity.Seller;

import java.util.List;

public interface SellerService {
    List<Seller> findAll();
}
