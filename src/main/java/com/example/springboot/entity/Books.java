package com.example.springboot.entity;

import javax.persistence.*;

@Entity
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private Integer cid;
    @Column
    private String bookName;
    @Column
    private String publisher;
    @Column
    private String author;
    @Column
    private Float price;
    @Column
    private String introduce;
    @Column
    private String ISBN;
    @Column(name="images_url")
    private String imagesUrl;
    @Column
    private String category;
    @Column
    private String modifyCategory;
    @Column
    private String ggct;
    @Column
    private String  returnGoods;
    @Column
    private String invoice;
    @Column
    private String promise;
    @Column
    private String region;
    @Column
    private String specialOffer;
    @Column
    private String name;

    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", cid=" + cid +
                ", bookName='" + bookName + '\'' +
                ", publisher='" + publisher + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", introduce='" + introduce + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", imagesUrl='" + imagesUrl + '\'' +
                ", category='" + category + '\'' +
                ", modifyCategory='" + modifyCategory + '\'' +
                ", ggct='" + ggct + '\'' +
                ", returnGoods='" + returnGoods + '\'' +
                ", invoice='" + invoice + '\'' +
                ", promise='" + promise + '\'' +
                ", region='" + region + '\'' +
                ", specialOffer='" + specialOffer + '\'' +
                ", name='" + name + '\'' +
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
