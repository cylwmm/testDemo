package com.cyl.redis;

import com.cyl.learn.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
public class RedisTest {
    @Autowired(required = false)
    private StringRedisTemplate stringRedisTemplate;

    @Autowired(required = false)
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    void getName(){
        stringRedisTemplate.opsForValue().set("name","dadadingdada!");
        System.out.println(stringRedisTemplate.opsForValue().get("name"));
    }

    @Test
    void setUser() {
        User user = new User();
        user.setName("dingdada");
        user.setAge("23");
        redisTemplate.opsForValue().set("user",user);
        System.out.println(redisTemplate.opsForValue().get("user"));
    }

}
