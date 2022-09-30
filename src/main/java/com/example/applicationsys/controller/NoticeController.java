package com.example.applicationsys.controller;

import com.example.applicationsys.dto.Notice;
import com.example.applicationsys.dto.Response;
import com.example.applicationsys.service.NoticeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/notice")
public class NoticeController {
    private NoticeService noticeService;

    public NoticeController(NoticeService noticeService){
        this.noticeService=noticeService;
    }

    @GetMapping("/all")
    public Response<Object> findAll(HttpServletRequest request){
        final List<Notice> notices = noticeService.findAll();
        return Response.builder()
                .data(notices)
                .message("notice find All")
                .url(request.getRequestURI())
                .build();
    }

    @GetMapping("/{id}")
    public Response<Object> findAll(HttpServletRequest request, @PathVariable("id") Long id){
        final Notice notice = noticeService.findById(id);
        return Response.builder()
                .data(notice)
                .message(id+" notice find")
                .url(request.getRequestURI())
                .build();
    }
}
