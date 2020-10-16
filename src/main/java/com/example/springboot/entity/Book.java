package com.example.springboot.entity;

import javax.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private Integer cid;    //分类id
    @Column
    private Integer sid;  //店铺名id
    @Column
    private String bookName;    //书名
    @Column
    private String publisher;   //出版社
    @Column
    private String author;  //作者名称
    @Column
    private Float price;    //价格
    @Column
    private String introduce;   //内容介绍
    @Column
    private String ISBN;    //书本编号
    @Column(name="images_url")
    private String imagesUrl;   //书本封面（图片）

    @Column
    private String modifyCategory;  //暂时用不到
    @Column
    private String ggct;    //暂时用不到
    @Column
    private String  returnGoods;    //暂时用不到
    @Column
    private String invoice;     //暂时用不到
    @Column
    private String promise;     //暂时用不到
    @Column
    private String region;      //发货地
    @Column
    private String specialOffer;      //特价

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", cid=" + cid +
                ", sid=" + sid +
                ", bookName='" + bookName + '\'' +
                ", publisher='" + publisher + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", introduce='" + introduce + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", imagesUrl='" + imagesUrl + '\'' +
                ", modifyCategory='" + modifyCategory + '\'' +
                ", ggct='" + ggct + '\'' +
                ", returnGoods='" + returnGoods + '\'' +
                ", invoice='" + invoice + '\'' +
                ", promise='" + promise + '\'' +
                ", region='" + region + '\'' +
                ", specialOffer='" + specialOffer + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getImagesUrl() {
        return imagesUrl;
    }

    public void setImagesUrl(String imagesUrl) {
        this.imagesUrl = imagesUrl;
    }

    public String getModifyCategory() {
        return modifyCategory;
    }

    public void setModifyCategory(String modifyCategory) {
        this.modifyCategory = modifyCategory;
    }

    public String getGgct() {
        return ggct;
    }

    public void setGgct(String ggct) {
        this.ggct = ggct;
    }

    public String getReturnGoods() {
        return returnGoods;
    }

    public void setReturnGoods(String returnGoods) {
        this.returnGoods = returnGoods;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public String getPromise() {
        return promise;
    }

    public void setPromise(String promise) {
        this.promise = promise;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSpecialOffer() {
        return specialOffer;
    }

    public void setSpecialOffer(String specialOffer) {
        this.specialOffer = specialOffer;
    }
}
