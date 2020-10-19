package com.example.springboot.service;
/**
 * @className : AdminService
 * @package: com.example.springboot.service
 * @Description : TODO
 * @date : 2020/10/14 15:09
 * @author : zpx
 */

import com.example.springboot.entity.Admin;
import com.example.springboot.utils.Result;

import java.util.List;

/**
 *
 *@InterfaceName AdminService
 *@Description TODO
 *@author 肖汉昌
 *@date 2020/10/14 15:09
 *@version 1.0
 **/
public interface AdminService {
    List<Admin>findAll();
    public Result insert(Admin admin);
    public Result delete(Integer id);

    Result<Admin> getById(Integer id);

    Result<Admin> update(Admin admin);

    public Result login(String adminName,String password );
}
