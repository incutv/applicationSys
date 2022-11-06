package com.example.applicationsys.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class Apply {
    private Long id;
    private Long lectureId;
    private String status;
    private String who;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
