package com.example.applicationsys.mapper.master;

import com.example.applicationsys.dto.Apply;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ApplyWriteMapper {
    public void apply(Apply apply);
}
