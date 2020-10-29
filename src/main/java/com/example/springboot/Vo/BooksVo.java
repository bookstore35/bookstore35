package com.example.springboot.Vo;

public class BooksVo {
    private Integer id;
    private String bookName;    //书名
    private String publisher;   //出版社
    private String author;  //作者名称
    private String introduce;   //内容介绍
    private String imagesUrl;   //书本封面（图片）
    private String name;    //分类名称
    private String sellerName; //店铺名称



    @Override
    public String toString() {
        return "BooksVo{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", publisher='" + publisher + '\'' +
                ", author='" + author + '\'' +
                ", introduce='" + introduce + '\'' +
                ", imagesUrl='" + imagesUrl + '\'' +
                ", name='" + name + '\'' +
                ", sellerName='" + sellerName + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

}
