package com.example.springboot.service;

import org.springframework.stereotype.Service;

/**
 * @author Liangyifeng
 * @created 2020/10/12/09:48
 */
@Service
public interface RedisService {
    /**
     * 新增key
     * @param key
     * @param value
     */
     public  void addKey(String key, String value);

    /**
     * 通过key获取对应的value
     * @param key
     * @return
     */
     public  String getValueByKey(String key);
}
