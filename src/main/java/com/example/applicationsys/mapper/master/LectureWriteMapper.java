package com.example.applicationsys.mapper.master;

import com.example.applicationsys.dto.Lecture;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LectureWriteMapper {
    public void updateNowPerson(int nowPerson, Long id);
}
