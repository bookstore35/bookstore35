package com.example.springboot.service.impl;

import com.example.springboot.dao.ImagesDao;
import com.example.springboot.entity.Book;
import com.example.springboot.entity.Images;
import com.example.springboot.service.BookImagesService;
import com.example.springboot.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookImagesServiceImpl implements BookImagesService {
    @Autowired
    private ImagesDao imagesDao;

    @Override
    public Result delete(Integer id) {

        this.imagesDao.deleteById(id);
        return Result.success("删除成功！");
    }
}
