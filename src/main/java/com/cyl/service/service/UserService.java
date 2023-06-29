package com.cyl.service.service;

import com.cyl.common.ResourceResult;
import com.cyl.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> findAll();

    ResourceResult insertAll(User user);
}
