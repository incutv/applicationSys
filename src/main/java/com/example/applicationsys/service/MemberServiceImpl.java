package com.example.applicationsys.service;

import com.example.applicationsys.dto.Member;
import com.example.applicationsys.mapper.master.MemberWriteMapper;
import com.example.applicationsys.mapper.read.MemberReadMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService {
    private MemberWriteMapper memberWriteMapper;
    private MemberReadMapper memberReadMapper;
    private PasswordEncoder passwordEncoder;

    public MemberServiceImpl(MemberWriteMapper memberWriteMapper, MemberReadMapper memberReadMapper, PasswordEncoder passwordEncoder){
        this.memberWriteMapper = memberWriteMapper;
        this.memberReadMapper = memberReadMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    @Override
    public void signUp(Member member) {
        memberWriteMapper.signUp(member);
    }

    @Override
    public Member login(Member member) {
        Member memberInfo = memberReadMapper.findByEmail(member.getEmail());
        if(memberInfo == null){
            throw new RuntimeException("존재하지 않는 계정입니다.");
        }
        if(!passwordEncoder.matches(member.getPassword(),memberInfo.getPassword())){
            throw new RuntimeException("비밀번호가 일치하지 않습니다.");
        }
        return memberInfo;
    }
}
