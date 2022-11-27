package com.example.applicationsys.mapper.read;

import com.example.applicationsys.dto.Lecture;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LectureReadMapper {
    public Lecture findById(Long id);
}
