package com.cyl.service.service;

import com.cyl.domain.Department;
import org.springframework.stereotype.Service;

@Service
public interface DepartmentService {
    Department findById(String id);
}
