package com.example.springboot.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "book_order")
public class BookOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;   //主键ID,
    @Column
    private String oid; //订单编号
    @Column
    private Date create_time; //下单时间
    @Column
    private Date payment_time; //付款时间
    @Column
    private Date consign_time; //发货时间
    @Column
    private Date end_time;  //完成时间
    @Column
    private double total_price; //总计
    @Column
    private int status; //状态
    @Column
    private String address; //收货人地址
    @Column
    private String name; //收货人姓名
    @Column
    private String telephone; //收货人电话

    @Override
    public String toString() {
        return "BookOrder{" +
                "id=" + id +
                ", oid='" + oid + '\'' +
                ", create_time=" + create_time +
                ", payment_time=" + payment_time +
                ", consign_time=" + consign_time +
                ", end_time=" + end_time +
                ", total_price=" + total_price +
                ", status=" + status +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getPayment_time() {
        return payment_time;
    }

    public void setPayment_time(Date payment_time) {
        this.payment_time = payment_time;
    }

    public Date getConsign_time() {
        return consign_time;
    }

    public void setConsign_time(Date consign_time) {
        this.consign_time = consign_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
