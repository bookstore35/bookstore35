package com.example.springboot.entity;

import javax.persistence.*;

/**
 * @author Liangyifeng
 * @created 2020/9/30/14:53
 */
@Entity
@Table(name = "user_address")
public class UserAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;        // 收货Id

    @Column(name="user_id" ,length = 11)
    private Integer userId ;  // 用户Id

    @Column(length = 20)
    private String name;        // 收货人姓名

    @Column(length = 100)
    private String region;  // 地区

    @Column(length = 120)
    private String address;  //地址信息

    @Column(length = 20)
    private String label;  // 标签

    @Column(name="default_address")
    private Boolean defaultAddress;  //是否默认地区

    @Column(length = 20)
    private Integer code ;  //邮政编码


}
