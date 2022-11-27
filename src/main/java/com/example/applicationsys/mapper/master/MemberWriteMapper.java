package com.example.applicationsys.mapper.master;

import com.example.applicationsys.dto.Member;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface MemberWriteMapper {
    public void signUp(Member member);
}
