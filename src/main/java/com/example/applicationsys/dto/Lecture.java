package com.example.applicationsys.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class Lecture {
    private Long id;
    private String name;
    private int maxPerson;
    private int nowPerson;
    private String who;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
