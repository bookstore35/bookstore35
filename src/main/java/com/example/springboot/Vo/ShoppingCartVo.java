package com.example.springboot.Vo;

public class ShoppingCartVo {

    private Integer id;     //购物车id
    private Integer bid;    //书本id
    private Integer number; //商品数量
    private Float price;    //价格
    private String bookName;    //书名
    private String publisher;   //出版社
    private String author;  //作者名称
    private String introduce;   //内容介绍
    private String imagesUrl;   //书本封面（图片）
    private String sellerName; //店铺名称

    @Override
    public String toString() {
        return "ShoppingCartVo{" +
                "id=" + id +
                ", bid=" + bid +
                ", number=" + number +
                ", price=" + price +
                ", bookName='" + bookName + '\'' +
                ", publisher='" + publisher + '\'' +
                ", author='" + author + '\'' +
                ", introduce='" + introduce + '\'' +
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

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
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
