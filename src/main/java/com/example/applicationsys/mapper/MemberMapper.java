package com.example.applicationsys.mapper;

import com.example.applicationsys.dto.Member;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface MemberMapper {
    public void signUp(Member member);
    public Member findByEmail(String email);
}
