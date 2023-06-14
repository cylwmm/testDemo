package com.cyl.domain;

import com.cyl.annotation.SetNeedValue;
import com.cyl.repository.JDBC.DepartmentRepository;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder
public class User {
    String id;
    String name;
    String age;
    String password;
    String departmentId;
    @SetNeedValue(
            beanClass = DepartmentRepository.class,
            param = "departmentId",
            method = "findByIdAndDeletedIsFalse",
            targetField = "name")
    String departmentName;
    LocalDateTime createTime;
    LocalDateTime updateTime;
    Boolean deleted;
}
