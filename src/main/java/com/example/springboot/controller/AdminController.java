package com.example.springboot.controller;

import com.example.springboot.entity.Admin;
import com.example.springboot.entity.User;
import com.example.springboot.service.AdminService;
import com.example.springboot.service.BookService;
import com.example.springboot.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 管理员接口类
 */
@RestController
@RequestMapping("/admin")
public class AdminController {


    @Autowired
    private AdminService adminService;

    /**
     * 查找全部管理员
     * @return
     */
    @GetMapping("/findAll")
    public Result<Admin> findAll(){
        return Result.success(adminService.findAll());
    }

    /**
     * 根据id查询管理员信息
     * @param id
     * @return
     */
    @GetMapping("/getById")
    public Result<Admin> getById(Integer id){
        return adminService.getById(id);
    }

    /**
     * 添加管理员信息
     * @param admin
     * @return
     */
    @PostMapping("/insert")
    public Result<Admin> insert(@RequestBody Admin admin) {
        return this.adminService.insert(admin);
    }

    /**
     * 删除管理员
     * @param id
     * @return
     */
    @DeleteMapping("/delete")
    public Result<Admin> deleteById(Integer id){
        return this.adminService.delete(id);
    }

    /**
     * 修改管理员信息
     * @param admin
     * @return
     */
    @PostMapping("/update")
    public Result<Admin> update(@RequestBody Admin admin){
        return this.adminService.update(admin);
    }

    /**
     * 管理员登录
     * @param adminName 账号
     * @param password  密码
     * @param request
     * @return
     */
    @GetMapping("/login")
    public Result<Admin>  login(String adminName , String password , HttpServletRequest request){
        return adminService.login(adminName ,password);
    }
}
