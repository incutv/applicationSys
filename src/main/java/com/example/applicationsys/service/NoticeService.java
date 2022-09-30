package com.example.applicationsys.service;

import com.example.applicationsys.dto.Notice;

import java.util.List;


public interface NoticeService {
    public List<Notice> findAll();
    public Notice findById(Long id);
}
