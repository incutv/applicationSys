package com.example.applicationsys.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class Member {
    private long id;
    private String email;
    private String password;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
