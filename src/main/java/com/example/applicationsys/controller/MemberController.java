package com.example.applicationsys.controller;

import com.example.applicationsys.dto.Member;
import com.example.applicationsys.dto.Response;
import com.example.applicationsys.dto.req.MemberReq;
import com.example.applicationsys.service.MemberService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/member")
public class MemberController {
    private MemberService memberService;
    private PasswordEncoder passwordEncoder;

    public MemberController(MemberService memberService, PasswordEncoder passwordEncoder){
        this.memberService=memberService;
        this.passwordEncoder=passwordEncoder;
    }

    @PostMapping("")
    public Response<Object> saveMember(HttpServletRequest request,@RequestBody MemberReq memberReq){
        Member member = Member.builder()
                .email(memberReq.email)
                .password(passwordEncoder.encode(memberReq.password))
                .build();

        memberService.signUp(member);

        return Response.builder()
                .message("create Member")
                .url(request.getRequestURI())
                .build();
    }

    @PostMapping("/login")
    public Response<Object> loginMember(HttpServletRequest request,@RequestBody MemberReq memberReq){
        Member member = Member.builder()
                .email(memberReq.email)
                .password(memberReq.password)
                .build();

        Member loginMember = memberService.login(member);
        HttpSession session = request.getSession(true);
        session.setAttribute("member", loginMember);

        return Response.builder()
                .message("login Member")
                .url(request.getRequestURI())
                .build();
    }

}
