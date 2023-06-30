package com.cyl.control;
import com.cyl.service.service.RedisTestService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@Slf4j
@RestController
@RequestMapping
public class RedisTestApiImpl {
    private final RedisTestService redisTestService;

    @GetMapping("/testRedis")
    public String testRedis() {
        return redisTestService.testRedis();
    }
}
