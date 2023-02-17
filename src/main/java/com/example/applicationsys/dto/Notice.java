package com.example.applicationsys.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Notice {
    private long id;
    private String[] title;
    private String content;
    private String who;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}

