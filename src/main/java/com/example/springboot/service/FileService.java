package com.example.springboot.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

public interface FileService {
    public String upload(MultipartFile file);

    public void  download(String name, HttpServletResponse response) throws  Exception;


}
