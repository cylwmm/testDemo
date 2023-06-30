package com.cyl.service.impl;

import com.cyl.service.service.RedisTestService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RedisTestServiceImpl implements RedisTestService {
    @Autowired
    private StringRedisTemplate template;

    @Override
    public String testRedis() {
        template.opsForValue().set("yulong", "cai");
        return template.opsForValue().get("yulong");
    }
}
