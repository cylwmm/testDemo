package com.cyl.domain;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder
public class Department {
    String id;
    String name;
    LocalDateTime createTime;
    LocalDateTime updateTime;
    Boolean deleted;
}
