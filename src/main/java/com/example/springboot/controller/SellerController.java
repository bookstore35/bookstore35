package com.example.springboot.controller;

import com.example.springboot.entity.Seller;
import com.example.springboot.service.SellerService;
import com.example.springboot.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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
    @PostMapping("/insert")
    public Result<Seller> insert(@RequestBody Seller seller) {
        return sellerService.insert(seller);
    }

    /**
     * 修改商家信息
     * @param seller
     * @return
     */
    @PostMapping("/update")
    public Result<Seller> update(@RequestBody Seller seller){
        return sellerService.update(seller);
    }

    /**
     * 删除商家
     * @param id
     * @return
     */
    @DeleteMapping("/delete")
    public Result<Seller> deleteById(Integer id){
        return sellerService.delete(id);
    }

    /**
     * 商家登录
     * @param username  账号
     * @param password  密码
     * @param request
     * @return
     */
    @GetMapping("/login")
    public Result<Seller>  login(String username , String password , HttpServletRequest request){
        return sellerService.login(username ,password);
    }
}
