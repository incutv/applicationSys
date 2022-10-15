package com.example.applicationsys.service;

import com.example.applicationsys.dto.Member;
import com.example.applicationsys.mapper.MemberMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService {
    private MemberMapper memberMapper;
    private PasswordEncoder passwordEncoder;

    public MemberServiceImpl(MemberMapper memberMapper, PasswordEncoder passwordEncoder){
        this.memberMapper = memberMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    @Override
    public void signUp(Member member) {
        memberMapper.signUp(member);
    }

    @Override
    public Member login(Member member) {
        Member memberInfo = memberMapper.findByEmail(member.getEmail());
        if(memberInfo == null){
            throw new RuntimeException("존재하지 않는 계정입니다.");
        }
        if(!passwordEncoder.matches(member.getPassword(),memberInfo.getPassword())){
            throw new RuntimeException("비밀번호가 일치하지 않습니다.");
        }
        return memberInfo;
    }
}
