package com.cyl.redis;

import com.cyl.api.RedisApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
public class RedisTest implements RedisApi {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping("/testRedis")
    @Override
    public void testRedis() {
        redisTemplate.opsForValue().set("userName","zhangSan");

        String str = redisTemplate.opsForValue().get("userName");

        System.out.println(str);
    }
}
