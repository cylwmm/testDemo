package com.cyl.response;

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
    LocalDateTime createTime;
    LocalDateTime updateTime;
    Boolean deleted;
}
