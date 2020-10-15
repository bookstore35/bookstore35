package com.example.springboot.controller;

import com.example.springboot.entity.Seller;
import com.example.springboot.service.SellerService;
import com.example.springboot.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 商家管理
 */
@RestController
@RequestMapping("/seller")
public class SellerController {
    @Autowired
    private SellerService sellerService;

    /**
     * 查询所以商家
     * @return
     */
    @GetMapping("/findAll")
    public Result<Seller> findAll(){
        return Result.success(sellerService.findAll());
    }

    /**
     * 添加商家
     * @param seller
     * @return
     */
    @PostMapping
    @RequestMapping("/insert")
    public Result<Seller> insert(@RequestBody Seller seller) {
        return null;
    }

    /**
     * 修改商家信息
     * @param seller
     * @return
     */
    @PostMapping
    @RequestMapping("/update")
    public Result<Seller> update(@RequestBody Seller seller){
        return null;
    }

    /**
     * 删除商家
     * @param id
     * @return
     */
    @DeleteMapping
    @RequestMapping("/delete")
    public Result<Seller> deleteById(Integer id){
        return null;
    }

}