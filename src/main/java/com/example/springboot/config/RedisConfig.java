package com.example.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author Liangyifeng
 * @created 2020/10/10/10:02
 */
public class RedisConfig {
    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        return new JedisConnectionFactory();
    }
    @Bean RedisTemplate<String, String>redisTemplate(RedisConnectionFactory factory)
    {
        RedisTemplate<String, String> template = new RedisTemplate<String, String>();
        // 设置redis连接工厂
        template.setConnectionFactory(jedisConnectionFactory());
        // 设置 键的序列化器
        template.setKeySerializer(new StringRedisSerializer());
        // 设置 值的序列化器
        template.setValueSerializer(new StringRedisSerializer());
        return template;
    }
}