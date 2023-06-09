package com.cyl.control;

import com.cyl.response.UserResponseDto;
import com.cyl.service.UserServiceImp;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@Slf4j
@RestController
@RequestMapping("/user")
public class UserApi {
    private final UserServiceImp userServiceImp;

    @GetMapping("/findAll")
    List<UserResponseDto> findAll() {
        return userServiceImp.findAll();
    }
}
