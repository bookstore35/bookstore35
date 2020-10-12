package com.example.springboot.entity;

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
public class seller {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer seller_id;

    @Column
    private String seller_name;
    @Column
    private String pwd;
    @Column
    private String address;

    public Integer getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(Integer seller_id) {
        this.seller_id = seller_id;
    }

    public String getSeller_name() {
        return seller_name;
    }

    public void setSeller_name(String seller_name) {
        this.seller_name = seller_name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "seller{" +
                "seller_id=" + seller_id +
                ", seller_name='" + seller_name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
/**
 * @ClassName : seller
 * @Description : TODO
 * @author : zpx
 * @date : 2020/9/29 10:47
 * @version : 1.0
 **/