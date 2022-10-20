package com.example.applicationsys.mapper;

import com.example.applicationsys.dto.Lecture;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LectureMapper {
    public Lecture findById(Long id);
    public void updateNowPerson(int nowPerson, Long id);
}
