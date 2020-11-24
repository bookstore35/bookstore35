package com.example.springboot.config;

import com.example.springboot.service.RedisService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Liangyifeng
 * @created 2020/9/28/14:06
 */

@Component
public class JwtConfig {



    private String secret = "ZW]4l5JH[m6Lm)LaQEjpb!4E0lRaG(";
    // 外部http请求中 header中 token的 键值
    private String header = "token";
    // 新建HashMap
//    private static Map<String, String> tokenMap = new HashMap<>();

    @Autowired
    private RedisService redisService;

    /**
     * 生成token
     *
     * @param subject
     * @return
     * 创建Token
     */
    public String createToken(String subject) {
        // 获取当前的系统time
        Date nowDate = new Date();
        //获取当前的时间,还能指定需要获取的时间
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(nowDate);
        calendar.add(Calendar.DAY_OF_MONTH, 10);
        //超时时间
        Date expireDate = calendar.getTime();
        //使用 JWT 创建 token 对象
        String userToken = Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setSubject(subject) //用户名.
                .setIssuedAt(nowDate)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
        // Map把token添加到缓存中
        redisService.addKey(subject,userToken);
//        tokenMap.put(subject, userToken);
        return userToken;
    }
        //创建刷新token方法
    public String createRefreshToken(String subject) {
        Date nowDate = new Date();

        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setSubject(subject)
                .setIssuedAt(nowDate)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    /**
     * 获取token中注册信息
     *
     * @param token
     * @return
     */
    public Claims getTokenClaim(String token) {
        try {
            return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 验证token是否过期失效
     *
     * @param expirationTime
     * @return
     */
    public boolean isTokenExpired(Date expirationTime) {
        return expirationTime.before(new Date());
    }
    /**
     * 获取token失效时间
     *
     * @param token
     * @return
     */
    public Date getExpirationDateFromToken(String token) {
        return getTokenClaim(token).getExpiration();
    }

    /**
     * 获取用户名从token中
     */
    public String getUsernameFromToken(String token) {
        Claims claims =getTokenClaim(token);
        if (claims == null){
            return "";
        }
        return getTokenClaim(token).getSubject();
    }

    /**
     * 获取jwt发布时间
     */
    public Date getIssuedAtDateFromToken(String token) {
        return getTokenClaim(token).getIssuedAt();
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

//    public static Map<String, String> getTokenMap() {
//        return tokenMap;
//    }
//
//    public static void setTokenMap(Map<String, String> tokenMap) {
//        JwtConfig.tokenMap = tokenMap;
//    }



}
