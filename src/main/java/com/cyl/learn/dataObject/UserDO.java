package com.cyl.learn.dataObject;

import com.cyl.learn.common.BaseDO;
import lombok.*;
import org.springframework.data.relational.core.mapping.Table;

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
