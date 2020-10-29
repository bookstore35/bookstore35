package com.example.springboot.Vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.example.springboot.entity.Book;
import com.example.springboot.entity.Images;

import javax.persistence.Embedded;
import java.util.List;

public class ImagesVo extends Book {

    @Embedded
    @TableField(exist = false)
    private List<Images> imagesDetails; //详细图片集合

    @Embedded
    @TableField(exist = false)
    private List<Images> imagesThumbnails; //缩略图片集合

    public List<Images> getImagesDetails() {
        return imagesDetails;
    }

    public void setImagesDetails(List<Images> imagesDetails) {
        this.imagesDetails = imagesDetails;
    }

    public List<Images> getImagesThumbnails() {
        return imagesThumbnails;
    }

    public void setImagesThumbnails(List<Images> imagesThumbnails) {
        this.imagesThumbnails = imagesThumbnails;
    }
}
