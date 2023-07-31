package com.cyl.learn.convert;

import com.cyl.learn.dataObject.DepartmentDO;
import com.cyl.learn.domain.Department;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DepartmentConvert {
    DepartmentConvert INSTANCE = Mappers.getMapper(DepartmentConvert.class);
    Department toDomain(DepartmentDO departmentDO);
}
