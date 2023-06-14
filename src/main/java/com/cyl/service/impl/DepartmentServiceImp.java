package com.cyl.service.impl;

import com.cyl.convert.DepartmentConvert;
import com.cyl.dataObject.DepartmentDO;
import com.cyl.domain.Department;
import com.cyl.repository.JDBC.DepartmentRepository;
import com.cyl.service.service.DepartmentService;
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
