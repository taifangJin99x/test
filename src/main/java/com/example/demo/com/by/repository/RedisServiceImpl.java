package com.example.demo.com.by.repository;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RedisServiceImpl {
    private final StringRedisTemplate stringRedisTemplate;

    public RedisServiceImpl(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }
    //定义添加数据方法
    public boolean add(String key,String value){
        stringRedisTemplate.opsForValue().set(key,value);
        return true;
    }
    //定义取数据方法
    public String get(String key){
        String value = stringRedisTemplate.opsForValue().get(key);
        return value;
    }

}
