package com.example.springboot.controller;

import com.example.springboot.service.FileService;
import com.example.springboot.utils.Result;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * 上传接口
 */
@RestController
@RequestMapping("/file")
public class FileController {


    private static Logger logger= LoggerFactory.getLogger(FileController.class);
    @Autowired
    private FileService fileService;


    /**
     * 上传接口
     * @param file
     * @param session
     * @return
     * @throws Exception
     */
    @PostMapping("/upload")//上传接口
        public Result<String> upload2(MultipartFile file, HttpSession session) throws  Exception{
            String filePath = fileService.upload(file);

        return  Result.success(filePath);
    }


    @GetMapping("/dwonload")//下载接口
    public void dwonload(@RequestParam String name, HttpServletResponse response) throws  Exception{
        fileService.download(name,response);
    }
}
