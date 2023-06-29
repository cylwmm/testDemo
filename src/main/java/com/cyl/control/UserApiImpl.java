package com.cyl.control;

import com.cyl.Api;
import com.cyl.common.ResourceResult;
import com.cyl.convert.UserConvert;
import com.cyl.domain.User;
import com.cyl.request.UserRequestDto;
import com.cyl.response.UserResponseDto;
import com.cyl.service.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @Override
    @PostMapping("/user/add")
    public ResourceResult insertAll(@RequestBody UserRequestDto userRequestDtos) {
        User user = User.buildUser(userRequestDtos);
        return userService.insertAll(user);
    }
}
