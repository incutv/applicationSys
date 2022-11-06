package com.example.applicationsys.service;

import com.example.applicationsys.dto.Member;

public interface MemberService {
    public void signUp(Member member);
    public Member login(Member member);
}
