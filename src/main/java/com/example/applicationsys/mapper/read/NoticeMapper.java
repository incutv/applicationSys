package com.example.applicationsys.mapper.read;

import com.example.applicationsys.dto.Notice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {
    public List<Notice> findAll();
    public Notice findById(Long id);
}
