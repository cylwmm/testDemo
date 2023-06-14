package com.cyl.service.service;

import com.cyl.domain.User;
import com.cyl.response.UserResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> findAll();
}
