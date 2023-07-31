package com.cyl.learn.repository.JDBC;

import com.cyl.learn.dataObject.DepartmentDO;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<DepartmentDO, String> {
    DepartmentDO findByIdAndDeletedIsFalse(String id);
}
