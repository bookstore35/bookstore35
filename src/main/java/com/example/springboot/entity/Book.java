package com.example.springboot.entity;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

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

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", publisher='" + publisher + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", introduce='" + introduce + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", imagesUrl='" + imagesUrl + '\'' +
                '}';
    }
}
