package com.example.applicationsys.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Response<T> {
    private String message;
    private String url;
    private T data;
}
