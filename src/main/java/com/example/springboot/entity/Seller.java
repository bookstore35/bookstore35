package com.example.springboot.entity;

import sun.security.util.Password;

import javax.persistence.*;

/**
 * @author : zpx
 * @className : seller
 * @package: com.example.springboot.entity
 * @Description : TODO
 * @date : 2020/9/29 10:47
 */
@Entity
@Table(name = "seller")
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String seller_name; //店铺名称
    @Column
    private String username; //用户名
    @Column
    private String password; //密码
    @Column
    private String address; //地址


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSeller_name() {
        return seller_name;
    }

    public void setSeller_name(String seller_name) {
        this.seller_name = seller_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
/**
 * @ClassName : seller
 * @Description : TODO
 * @author : zpx
 * @date : 2020/9/29 10:47
 * @version : 1.0
 **/