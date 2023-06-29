package com.cyl.domain;

import com.cyl.common.AuditAggregateRoot;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class Department extends AuditAggregateRoot {
    private String name;
}
