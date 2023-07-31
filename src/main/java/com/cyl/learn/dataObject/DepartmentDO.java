package com.cyl.learn.dataObject;

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
    private String id;
    private String name;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Boolean deleted;
}
