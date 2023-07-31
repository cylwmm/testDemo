package com.cyl.globalhandleexception;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController
public class ExceptionTest {
    @PostMapping(value = "/error")
    public void error() {
        int i = 9/0;
    }

    @PostMapping(value = "/error1")
    public void error1() {
       throw new BusinessException(1000,"业务异常");
    }
}
