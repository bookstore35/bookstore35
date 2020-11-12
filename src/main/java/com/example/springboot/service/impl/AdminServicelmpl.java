package com.example.springboot.service.impl;

import com.example.springboot.dao.AdminDao;
import com.example.springboot.entity.Admin;
import com.example.springboot.entity.Book;
import com.example.springboot.entity.User;
import com.example.springboot.service.AdminService;
import com.example.springboot.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : zpx
 * @className : AdminServicelmpl
 * @package: com.example.springboot.service.impl
 * @Description : TODO
 * @date : 2020/10/14 15:10
 */
@Service
public class AdminServicelmpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    public List<Admin> findAll() {
        return adminDao.findAll();
    }

    @Override
    public Result insert(Admin admin) {
        Admin old = this.adminDao.findByAdminName(admin.getAdminName());
        if (old != null) {
            return Result.error("管理员已存在");
        }
        admin = this.adminDao.save(admin);
        return Result.success(admin);
    }

    @Override
    public Result delete(Integer id) {
        this.adminDao.deleteById(id);
        return Result.success("删除成功！");
    }

    @Override
        public Result<Admin> getById(Integer id) {
            Admin admin = adminDao.findById(id).get();//根据id查询管理员;
            return Result.success(admin);
    }

    @Override
    public Result<Admin> update(Admin admin) {
        this.adminDao.save(admin);
        return Result.success("修改成功!");
    }

    @Override
    public Result login(String adminName, String password) {
        Admin admin = this.adminDao.getByAdminName(adminName);
        if (admin == null) {
            return Result.error("用户名不存在");
        }
        if (!password.equals(admin.getPassword())) {
            return Result.error("密码错误");
        }
        return Result.success("登录成功！");
    }
}

/**
 * @ClassName : AdminServicelmpl
 * @Description : TODO
 * @author : zpx
 * @date : 2020/10/14 15:10
 * @version : 1.0
 **/