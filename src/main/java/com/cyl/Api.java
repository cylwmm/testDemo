package com.cyl;

import com.cyl.response.UserResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/user")
@RestController
public interface Api {
    @GetMapping("/findAll")
    List<UserResponseDto> findAll();
}
