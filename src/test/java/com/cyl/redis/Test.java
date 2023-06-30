package com.cyl.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class Test {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping("/testRedis")
    public void testRedis() {
        redisTemplate.opsForValue().set("userName","zhangSan");

        String str = redisTemplate.opsForValue().get("userName");

        System.out.println(str);
    }
}
