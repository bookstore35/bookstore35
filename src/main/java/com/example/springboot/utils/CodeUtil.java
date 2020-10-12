package com.example.springboot.utils;

/**
 * @author Liangyifeng
 * @created 2020/9/30/09:37
 */

import com.example.springboot.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 将获取到的前端参数转为string类型
 * @return
 */
@Component
public class CodeUtil {
    /**
     * 将获取到的前端参数转为string类型
     * @param request
     * @param key
     * @return
     */


    @Autowired
    private  RedisService redisService;


    public static String getString(HttpServletRequest request, String key) {
        try {
            String result = request.getParameter(key); //获取浏览器输入的验证码参数
            if(result != null) {
                result = result.trim();
            }
            if("".equals(result)) {
                result = null;
            }
            return result;
        }catch(Exception e) {
            return null;
        }
    }


    /**
     * 验证码校验
     * @param request
     * @return
     */
    public  boolean checkVerifyCode(HttpServletRequest request) {

        //1.获取生成的验证码
        //String verifyCodeExpected = (String) request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);

        String id = request.getSession().getId();
        String verifyCodeExpected = redisService.getValueByKey(id);


        //2-1.获取用户输入的验证码---验证码的值

        String verifyCodeActual = CodeUtil.getString(request, "verifyCodeActual");


        //3.判断逻辑
        if(verifyCodeActual == null ||!verifyCodeActual.equals(verifyCodeExpected)) {
            return false;
        }
        return true;

    }
}