package com.cyl.control;

import com.cyl.Api;
import com.cyl.convert.UserConvert;
import com.cyl.response.UserResponseDto;
import com.cyl.service.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Slf4j
@RestController
@RequestMapping
public class UserApiImpl implements Api {
    private final UserService userService;

    private final UserConvert convert = UserConvert.INSTANCE;

    @GetMapping("/user/findAll")
    public List<UserResponseDto> findAll() {
        return userService.findAll().stream().map(convert::toResponse).collect(Collectors.toList());
    }
}
