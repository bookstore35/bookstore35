package com.example.springboot.config;

import com.example.springboot.filter.BookFilter1;
import com.example.springboot.filter.BookFilter2;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * WebMvcConfigurer类作用：直接点就是web的配置都可以在这类里面干
 */
@Configuration
public class FilterConfig implements WebMvcConfigurer {

    /**
     * 自定义拦截规则
     * <p>
     * 可以添加多个拦截器，先添加的拦截器优先执行
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns - 用于添加拦截规则
        // excludePathPatterns - 用户排除拦截
        registry.addInterceptor(new BookFilter1())
                .addPathPatterns("/**")
                .excludePathPatterns("/index.html", "/", "/user/login");

        registry.addInterceptor(new BookFilter2())
                .addPathPatterns("/**")
                .excludePathPatterns("/index.html", "/", "/user/login");
    }
}