package com.example.springboot.service.impl;

import com.example.springboot.dao.SellerDao;
import com.example.springboot.entity.Seller;
import com.example.springboot.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerServiceImpl implements SellerService {
    @Autowired
    SellerDao sellerDao;

    @Override
    public List<Seller> findAll() {
        return sellerDao.findAll();
    }
}
