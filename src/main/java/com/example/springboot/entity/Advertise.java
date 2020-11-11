package com.example.springboot.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * 广告图片
 */
@Entity
@Table(name = "advertise")
public class Advertise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String url;//链接地址

    @Column
    private String image;//图片地址

    @Column
    private Integer type;//类型，0：商品，1：店铺，2：链接

    @Column
    private Integer sid;//对应的商品或店铺id

    @Column
    private Date beginTime;//开始时间

    @Column
    private Date endTime;//结束时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
