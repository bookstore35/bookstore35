package com.example.springboot.filter;

/**
 * @author Liangyifeng
 * @created 2020/9/28/14:11
 */

import com.example.springboot.aop.PassToken;
import com.example.springboot.aop.UserLoginToken;
import com.example.springboot.config.JwtConfig;
import com.example.springboot.service.RedisService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.SignatureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;


public class TokenInterceptor extends HandlerInterceptorAdapter {

    //注入  JwtConfig
    @Autowired
    private JwtConfig jwtConfig;

    @Autowired
    private RedisService redisService;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws SignatureException, IOException {

        request.getRequestURI();
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        /** 检查是否有passtoken注释，有则跳过认证 */
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }

        /** 检查有没有需要用户权限的注解 */
        if (method.isAnnotationPresent(UserLoginToken.class)) {
            /** Token 验证 */
            String token = request.getHeader(jwtConfig.getHeader());
            if (StringUtils.isEmpty(token)) {
                token = request.getParameter(jwtConfig.getHeader());
            }
            if (StringUtils.isEmpty(token)) {
                response.sendError(401, "token信息不能为空");
                return false;
            }
            String userName = jwtConfig.getUsernameFromToken(token);
           // String compareToken = jwtConfig.getTokenMap().get(userName);
            String compareToken = redisService.getValueByKey(userName);
            if (compareToken == null || !compareToken.equals(token)) {
                response.sendError(400, "token不存在,请重新登录");
                return false;
            }

            UserLoginToken userLoginToken = method.getAnnotation(UserLoginToken.class);
            if (userLoginToken.required()) {
                Claims claims = null;
                try {
                    claims = jwtConfig.getTokenClaim(token);
                    if (claims == null || jwtConfig.isTokenExpired(claims.getExpiration())) {
                        response.sendError(400, "token已经失效,请重新登录");
                        return false;
                    }
                } catch (Exception e) {
                    response.sendError(400, "token已经失效,请重新登录");
                    return false;
                }
                /** 设置 identityId 用户身份ID */
                request.setAttribute("identityId", claims.getSubject());
                return true;
            }
            if (compareToken == null) {
                // 由于服务器war重新上传导致临时数据丢失,需要重新存储
                //jwtConfig.getTokenMap().put(userName, token);
                redisService.addKey(userName,token);
            }
        }

        return true;
    }
}
