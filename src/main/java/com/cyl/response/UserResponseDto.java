package com.cyl.response;

import com.cyl.annotation.SetNeedValue;
import com.cyl.repository.JDBC.DepartmentRepository;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder
public class UserResponseDto {
    String id;
    String name;
    String age;
    String password;
    String departmentId;
    String departmentName;
    LocalDateTime createTime;
    LocalDateTime updateTime;
    Boolean deleted;
}
