package com.cyl.service.impl;

import com.cyl.annotation.SetNeedMethod;
import com.cyl.common.ResourceResult;
import com.cyl.convert.UserConvert;
import com.cyl.dataObject.UserDO;
import com.cyl.domain.User;
import com.cyl.repository.JDBC.UserRepository;
import com.cyl.request.UserRequestDto;
import com.cyl.service.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@AllArgsConstructor
@Service
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;
    private final UserConvert convert = UserConvert.INSTANCE;

    @SetNeedMethod
    public List<User> findAll() {
        return userRepository.findAll()
                .stream()
                .map(convert::toDomain).collect(Collectors.toList());
    }

    @Override
    public ResourceResult insertAll(User user) {
        UserDO save = userRepository.save(convert.toDO(user));
        return ResourceResult.builder().id(save.getId()).build();
    }
}
