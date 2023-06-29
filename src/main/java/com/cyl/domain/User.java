package com.cyl.domain;

import com.cyl.annotation.SetNeedValue;
import com.cyl.common.AuditAggregateRoot;
import com.cyl.common.BaseDO;
import com.cyl.repository.JDBC.DepartmentRepository;
import com.cyl.request.UserRequestDto;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

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
