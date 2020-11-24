package com.example.springboot.controller;

import cn.apiclub.captcha.Captcha;
import cn.apiclub.captcha.backgrounds.GradiatedBackgroundProducer;
import cn.apiclub.captcha.gimpy.FishEyeGimpyRenderer;

import com.example.springboot.service.impl.RedisServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author Liangyifeng
 * @created 2020/10/10/10:08
 */
@RestController
@RequestMapping("captcha")
public class CodeController {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private RedisServiceImpl redisService;
    private static int captchaExpires = 3*60; //超时时间3min
    private static int captchaW = 110;  //宽度
    private static int captchaH = 40;   //高度



    @RequestMapping(value = "getcaptcha", method = RequestMethod.GET, produces = MediaType.IMAGE_PNG_VALUE)
    public @ResponseBody
    byte[] getCaptcha(HttpServletResponse response, HttpSession session) throws IOException {
        //生成验证码
        //String uuid = UUID.randomUUID().toString();
        String sessionId = session.getId();
        Captcha captcha = new Captcha.Builder(captchaW, captchaH)
                .addText().addBackground(new GradiatedBackgroundProducer())
                .gimp(new FishEyeGimpyRenderer())
                .build();
        //将验证码以<key,value>形式缓存到redis

        redisTemplate.opsForValue().set(sessionId, captcha.getAnswer(), captchaExpires, TimeUnit.SECONDS);

        // 将验证码key，及验证码的图片返回
        Cookie cookie = new Cookie("CaptchaCode",sessionId);
        response.addCookie(cookie);

        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        try {
            ImageIO.write(captcha.getImage(), "png", bao);
            return bao.toByteArray();
        } catch (IOException e) {
            return null;
        }finally {
            bao.close();
        }

    }

}
