package com.cyl.control;

import com.cyl.service.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestDemoApplicationTests {

    @Autowired
    UserService userService;
    @Test
    void should_find_all_success() {
        userService.findAll();
    }

}
