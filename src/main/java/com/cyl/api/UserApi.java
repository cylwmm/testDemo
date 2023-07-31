package com.cyl.api;

import com.cyl.learn.common.ResourceResult;
import com.cyl.learn.request.UserRequestDto;
import com.cyl.learn.response.UserResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/user")
@RestController
public interface UserApi {
    @GetMapping("/findAll")
    List<UserResponseDto> findAll();

    @PostMapping("/add")
    ResourceResult insertAll(@RequestBody UserRequestDto userRequestDtos);
}
