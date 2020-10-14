package com.example.springboot.controller;

import com.example.springboot.entity.Admin;
import com.example.springboot.service.AdminService;
import com.example.springboot.service.BookService;
import com.example.springboot.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping
    @RequestMapping("/getById")
    public Result<Admin> getById(Integer id){
        return adminService.getById(id);
    }

    /**
     * 添加管理员信息
     * @param admin
     * @return
     */
    @PostMapping
    @RequestMapping("/insert")
    public Result<Admin> insert(@RequestBody Admin admin) {
        return this.adminService.insert(admin);
    }

    /**
     * 删除管理员
     * @param id
     * @return
     */
    @DeleteMapping
    @RequestMapping("/delete")
    public Result<Admin> deleteById(Integer id){
        return this.adminService.delete(id);
    }

    /**
     * 修改管理员信息
     * @param admin
     * @return
     */
    @PostMapping
    @RequestMapping("/update")
    public Result<Admin> update(@RequestBody Admin admin){
        return this.adminService.update(admin);
    }
}
/**
 * @ClassName : AdminController
 * @Description : TODO
 * @author : zpx
 * @date : 2020/10/14 15:11
 * @version : 1.0
 **/