package com.cyl.learn.service.service;

import com.cyl.learn.common.ResourceResult;
import com.cyl.learn.domain.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    ResourceResult insertAll(User user);
}
