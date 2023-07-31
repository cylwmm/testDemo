package com.cyl.learn.service.impl;

import com.cyl.learn.annotation.SetNeedMethod;
import com.cyl.learn.common.ResourceResult;
import com.cyl.learn.convert.UserConvert;
import com.cyl.learn.dataObject.UserDO;
import com.cyl.learn.domain.User;
import com.cyl.learn.service.service.UserService;
import com.cyl.learn.repository.JDBC.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
