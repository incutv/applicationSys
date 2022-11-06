package com.example.applicationsys.service;

import com.example.applicationsys.dto.Notice;
import com.example.applicationsys.mapper.read.NoticeReadMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
public class NoticeServiceImpl implements NoticeService{

    private NoticeReadMapper noticeReadMapper;

    public NoticeServiceImpl(NoticeReadMapper noticeReadMapper){
        this.noticeReadMapper = noticeReadMapper;
    }

    @Cacheable("findAll")
    @Override
    public List<Notice> findAll() {
        return noticeReadMapper.findAll();
    }

    @Cacheable("findById")
    @Override
    public Notice findById(Long id) {
        return noticeReadMapper.findById(id);
    }
}
