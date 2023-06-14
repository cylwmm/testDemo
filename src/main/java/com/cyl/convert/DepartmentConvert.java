package com.cyl.convert;

import com.cyl.dataObject.DepartmentDO;
import com.cyl.domain.Department;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DepartmentConvert {
    DepartmentConvert INSTANCE = Mappers.getMapper(DepartmentConvert.class);
    Department toDomain(DepartmentDO departmentDO);
}
