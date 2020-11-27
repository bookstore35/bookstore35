package com.example.springboot.controller;

import com.example.springboot.Vo.ShoppingCartVo;
import com.example.springboot.aop.UserLoginToken;
import com.example.springboot.entity.ShoppingCart;
import com.example.springboot.entity.User;
import com.example.springboot.service.ShoppingCartService;
import com.example.springboot.utils.Result;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 购物车接口
 */
@RestController
@RequestMapping("/shoppingCart")
public class ShoppingCartController {
    @Autowired
    private ShoppingCartService shoppingCartService;


    /**
     * 根据id查询
     * @param id
     * @return
     */
    @GetMapping("/getById")
    public Result<ShoppingCart> getById(Integer id){

        return Result.success( shoppingCartService.getById(id));
    }

    /**
     * 根据用户id查询购物车所有商品
     * @param uid
     * @return
     */
    @GetMapping("/findByCart")
    public Result<ShoppingCartVo> findByCart(Integer uid){
        return Result.success(shoppingCartService.selectCart(uid));
    }

    /**
     * 添加购物车商品（用户id自动获取）
     * @param shoppingCart
     * @return
     */
    @UserLoginToken
    @PostMapping("/insert")
    public Result<ShoppingCart> insert(@RequestBody ShoppingCart shoppingCart, HttpServletRequest request) {

        String userName = request.getAttribute("identityId").toString();
        User user = shoppingCartService.findAllByUsername(userName);
        shoppingCart.setUid(user.getId());

        return shoppingCartService.insert(shoppingCart);
    }


    /**
     * 修改购物车商品数量
     * @param shoppingCart
     * @return
     */
    @PostMapping("/update")
    public Result<ShoppingCart> update(@RequestBody ShoppingCart shoppingCart){

        return shoppingCartService.update(shoppingCart);
    }


    /**
     * 删除购物车商品
     * @param id
     * @return
     */
    @Delete("/delete")
    public Result<ShoppingCart> deleteById(Integer id){
        return Result.success(shoppingCartService.delete(id));
    }




}
