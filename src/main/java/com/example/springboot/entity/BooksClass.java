package com.example.springboot.entity;

import com.baomidou.mybatisplus.annotation.TableField;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "books_Class")
public class BooksClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;    //分类名称

    @Column
    private Integer pid;    //对应上级分类

    @Column
    private Integer level;  //层次

    @Embedded
    @TableField(exist = false)
    private List<BooksClass> children; //子集


    @Override
    public String toString() {
        return "BooksClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pid=" + pid +
                ", level=" + level +
                ", children=" + children +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }


    public List<BooksClass> getChildren() {
        return children;
    }

    public void setChildren(List<BooksClass> children) {
        this.children = children;
    }
}
