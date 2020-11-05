package com.example.springboot.controller;



import com.example.springboot.entity.Images;
import com.example.springboot.service.BookImagesService;
import com.example.springboot.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

/**
 * 图片接口
 */
@RestController
@RequestMapping("/images")
public class BookImagesController {
    @Autowired
    private BookImagesService bookImagesService;

    /**
     * 删除图片
     * @param id
     * @return
     */
    @DeleteMapping("/delete")
    public Result<Images> deleteById(Integer id){
        return this.bookImagesService.delete(id);
    }
}
