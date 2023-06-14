package com.cyl.repository.JDBC;

import com.cyl.dataObject.DepartmentDO;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<DepartmentDO, String> {
    DepartmentDO findByIdAndDeletedIsFalse(String id);
}
