package com.example.springboot.dao;
/**
 * @className : AdminDao
 * @package: com.example.springboot.dao
 * @Description : TODO
 * @date : 2020/10/14 15:08
 * @author : zpx
 */

import com.example.springboot.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 *@InterfaceName AdminDao
 *@Description TODO
 *@author 肖汉昌
 *@date 2020/10/14 15:08
 *@version 1.0
 **/
public interface AdminDao extends JpaRepository<Admin,Integer> {
    Admin findByAdminName(String adminName);
}
