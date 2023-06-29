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
    private String id;
    private String name;
    private String age;
    private String password;
    private String departmentId;
    private String departmentName;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Boolean deleted;
}
