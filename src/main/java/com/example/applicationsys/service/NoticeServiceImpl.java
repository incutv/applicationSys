package com.example.applicationsys.service;

import com.example.applicationsys.dto.Notice;
import com.example.applicationsys.mapper.NoticeMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
public class NoticeServiceImpl implements NoticeService{

    private NoticeMapper noticeMapper;

    public NoticeServiceImpl(NoticeMapper noticeMapper){
        this.noticeMapper = noticeMapper;
    }

    @Cacheable("findAll")
    @Override
    public List<Notice> findAll() {
        return noticeMapper.findAll();
    }

    @Cacheable("findById")
    @Override
    public Notice findById(Long id) {
        return noticeMapper.findById(id);
    }
}
