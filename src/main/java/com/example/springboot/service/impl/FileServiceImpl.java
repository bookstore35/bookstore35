package com.example.springboot.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.springboot.service.FileService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {
/*    private static Logger logger= LoggerFactory.getLogger(FileService.class);*/



    @Override
    public String upload(MultipartFile file){
        if(file.isEmpty()){
            return "文件不能为空" ;
        }
        String  filePath ="E:/upload/"; //设置储存图片的路径
        /*String filePath = new File("src\\main\\resources\\static\\File").getAbsolutePath();//当前文件项目的绝对路径*/
        /*String fileName="E:/upload/"+file.getOriginalFilename();*/
        String fileName=file.getOriginalFilename();     //获取文件名加后缀
        String fileTyle=fileName.substring(fileName.lastIndexOf("."));  //获取文件的后缀名
        String newfileName = UUID.randomUUID().toString().replace("-", "")+fileTyle; //建立一个新的文件名加获取的文件名后缀
        File dast = new File(filePath+File.separator+newfileName); //建立一个文件流对象dast，里面的参数储存的位置加文件名
        try {
            FileOutputStream fileOutputStream=new FileOutputStream(dast);  //把dast放进fileOutputStream文件字节流对象进行储存，储存的位置为dast的文件路径
            IOUtils.copy(file.getInputStream(), fileOutputStream);
            //第一个参数是上传的文件化为文件字节流，即上传的文件.getInputStream()方法，第二个文件是上面储存的文件字节流对象
           /* logger.info("sccg1");//*/
            return "/upload/"+newfileName;//返回路径加文件名加后缀，getOriginalFilename()会返回文件名后缀，
        } catch (IOException e){
            /*logger.error("scsb2");*/
            e.printStackTrace(); }
        return "文件上传失败"; }


    public void  download(String name, HttpServletResponse response) throws  Exception {

        File file = new File("E:\\upload" + File.separator + name);

        if (!file.exists()) {
            throw new Exception("文件不存在");
        }
        response.setContentType("application/force-download");
        response.addHeader("Content-Disposition", "attachment;fileName=" + name);

        byte[] buffer = new byte[1024];
        try (FileInputStream fis = new FileInputStream(file);
             BufferedInputStream bis = new BufferedInputStream(fis)) {
            OutputStream os = response.getOutputStream();
            int i = bis.read(buffer);
            while (i != -1) {
                os.write(buffer, 0, i);
                i = bis.read(buffer);
            }
        }
    }

}
