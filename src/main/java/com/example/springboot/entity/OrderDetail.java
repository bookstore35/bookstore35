package com.example.springboot.entity;

import javax.persistence.*;

@Entity
@Table(name = "orderDetail")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String oid; //订单编号
    @Column
    private Integer bid;      //书本id
    @Column
    private String status;    //状态
    @Column
    private Integer number;   //商品数量
    @Column
    private Integer price;    //商品价格
    @Column
    private String bookName;    //书名
    @Column
    private String publisher;   //出版社
    @Column
    private String imagesUrl;   //书本封面（图片）
    @Column
    private String sellerName; //店铺名称

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", oid='" + oid + '\'' +
                ", bid=" + bid +
                ", status='" + status + '\'' +
                ", number=" + number +
                ", price=" + price +
                ", bookName='" + bookName + '\'' +
                ", publisher='" + publisher + '\'' +
                ", imagesUrl='" + imagesUrl + '\'' +
                ", sellerName='" + sellerName + '\'' +
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

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getImagesUrl() {
        return imagesUrl;
    }

    public void setImagesUrl(String imagesUrl) {
        this.imagesUrl = imagesUrl;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }
}
