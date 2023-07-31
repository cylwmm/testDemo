package com.cyl.learn.domain;

import com.cyl.learn.common.AuditAggregateRoot;
import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class Department extends AuditAggregateRoot {
    private String name;
}
