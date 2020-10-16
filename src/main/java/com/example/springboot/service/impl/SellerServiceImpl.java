package com.example.springboot.service.impl;

import com.example.springboot.dao.SellerDao;
import com.example.springboot.entity.Seller;
import com.example.springboot.service.SellerService;
import com.example.springboot.utils.Result;
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

    @Override
    public Result insert(Seller seller) {
        Seller old = this.sellerDao.findBySellerName(seller.getSellerName());
        if(old != null){
            return Result.error("店铺已存在");
        }
        seller = this.sellerDao.save(seller);
        return Result.success(seller);
    }

    @Override
    public Result update(Seller seller){
        seller = this.sellerDao.save(seller);
        return Result.success("修改成功!");
    }



    @Override
    public Result delete(Integer id){
        this.sellerDao.deleteById(id);
        return Result.success("删除成功！");
    }

}
