package com.cyl.learn.domain;

import com.cyl.learn.annotation.SetNeedValue;
import com.cyl.learn.common.AuditAggregateRoot;
import com.cyl.learn.repository.JDBC.DepartmentRepository;
import com.cyl.learn.request.UserRequestDto;
import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class User extends AuditAggregateRoot {
    private String name;
    private String age;
    private String password;
    private String departmentId;
    @SetNeedValue(
            beanClass = DepartmentRepository.class,
            param = "departmentId",
            method = "findByIdAndDeletedIsFalse",
            targetField = "name")
    String departmentName;
    public static User buildUser(UserRequestDto dto) {
        return User
                .builder()
                .name(dto.getName())
                .age(dto.getAge())
                .departmentId(dto.getDepartmentId())
                .password(dto.getPassword())
                .build();
    }
}
