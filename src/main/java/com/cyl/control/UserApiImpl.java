package com.cyl.control;

import com.cyl.Api;
import com.cyl.response.UserResponseDto;
import com.cyl.service.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@Slf4j
@RestController
@RequestMapping
public class UserApiImpl implements Api {
    private final UserService userService;

    @GetMapping("/user/findAll")
    public List<UserResponseDto> findAll() {
        return userService.findAll();
    }
}
