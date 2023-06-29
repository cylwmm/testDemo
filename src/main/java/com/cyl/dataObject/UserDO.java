package com.cyl.dataObject;

import com.cyl.common.BaseDO;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Table("user")
public class UserDO extends BaseDO {

    private String name;
    private String age;
    private String password;
    private String departmentId;

}
