package com.cyl.dataObject;

import lombok.*;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Table("user")
public class UserDO {
    String id;
    String name;
    String age;
    String password;
    LocalDateTime createTime;
    LocalDateTime updateTime;
    Boolean deleted;
}
