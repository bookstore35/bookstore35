package com.example.springboot;

import io.github.yedaxia.apidocs.Docs;
import io.github.yedaxia.apidocs.DocsConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);

        /*
        JApiDocs
         */
//        DocsConfig config = new DocsConfig();
//        config.setProjectPath("E:\\商城后台管理\\springboot"); // 项目根目录
//        config.setProjectName("springboot"); // 项目名称
//        config.setApiVersion("V1.0");       // 声明该API的版本
//        config.setDocsPath("E:\\JApiDocs\\test"); // 生成API 文档所在目录
//        config.setAutoGenerate(Boolean.TRUE);  // 配置自动生成
//        Docs.buildHtmlDocs(config); // 执行生成文档


    }

}
