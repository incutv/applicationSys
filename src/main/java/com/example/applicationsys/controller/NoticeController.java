package com.example.applicationsys.controller;

import com.example.applicationsys.dto.Notice;
import com.example.applicationsys.dto.Response;
import com.example.applicationsys.service.NoticeService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

        HttpSession session = request.getSession(true);
        Object object = session.getAttribute("member");
        System.out.println(object);

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

    @PostMapping("")
    public Response<Object> createNotice(HttpServletRequest request, @PathVariable("id") Long id){
        final Notice notice = noticeService.findById(id);
        return Response.builder()
                .data(notice)
                .message(id+" notice find")
                .url(request.getRequestURI())
                .build();
    }
}
