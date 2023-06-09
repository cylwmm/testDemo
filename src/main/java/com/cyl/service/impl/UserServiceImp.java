package com.cyl.service;

import com.cyl.convert.UserConvert;
import com.cyl.repository.UserRepository;
import com.cyl.response.UserResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class UserServiceImp {

    private final UserRepository userRepository;
    private final UserConvert convert = UserConvert.INSTANCE;

    public List<UserResponseDto> findAll() {
        return userRepository.findAll()
                .stream()
                .map(convert::toDomain)
                .map(convert::toResponse).collect(Collectors.toList());
    }
}
