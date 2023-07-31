package com.cyl.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public interface RedisApi {
    @GetMapping("/testRedis")
    void testRedis();
}
