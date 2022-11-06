package com.example.applicationsys.mapper;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NoticeMappertests {

    @Autowired
    NoticeMapper noticeMapper;

    @Test
    @DisplayName("공지사항 조회 확인")
    public void findNotice(){
        System.out.println(noticeMapper.findAll());
    }
}
