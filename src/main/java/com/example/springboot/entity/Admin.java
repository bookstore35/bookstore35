package com.example.springboot.entity;

import javax.persistence.*;

/**
 * @author : zpx
 * @className : AdminUser
 * @package: com.example.springboot.entity
 * @Description : TODO
 * @date : 2020/10/14 15:01
 */
@Entity
@Table(name = "admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String adminName;    //管理员名称

    @Column
    private String password; // 密码

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AdminUser{" +
                "id=" + id +
                ", adminName='" + adminName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
/**
 * @ClassName : AdminUser
 * @Description : TODO
 * @author : zpx
 * @date : 2020/10/14 15:01
 * @version : 1.0
 **/