package com.cyl.learn.service.impl;

import com.cyl.learn.convert.DepartmentConvert;
import com.cyl.learn.dataObject.DepartmentDO;
import com.cyl.learn.domain.Department;
import com.cyl.learn.repository.JDBC.DepartmentRepository;
import com.cyl.learn.service.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DepartmentServiceImp implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    private final DepartmentConvert convert = DepartmentConvert.INSTANCE;

    @Override
    public Department findById(String id) {
        DepartmentDO departmentDO = departmentRepository.findByIdAndDeletedIsFalse(id);

        return convert.toDomain(departmentDO);
    }
}
