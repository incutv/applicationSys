package com.example.applicationsys.mapper.read;

import com.example.applicationsys.dto.Member;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface MemberReadMapper {
    public Member findByEmail(String email);
}
