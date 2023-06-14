package com.cyl.dataObject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Table("department")
public class DepartmentDO {
    String id;
    String name;
    LocalDateTime createTime;
    LocalDateTime updateTime;
    Boolean deleted;
}
