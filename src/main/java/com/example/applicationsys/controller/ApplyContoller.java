package com.example.applicationsys.controller;

import com.example.applicationsys.dto.Apply;
import com.example.applicationsys.dto.Member;
import com.example.applicationsys.dto.Response;
import com.example.applicationsys.dto.req.ApplyReq;
import com.example.applicationsys.dto.req.MemberReq;
import com.example.applicationsys.service.ApplyService;
import com.example.applicationsys.service.ApplyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/apply")
public class ApplyContoller {
    /*private ApplyService applyService;

    public ApplyContoller(ApplyService applyService){
        this.applyService = applyService;
    }*/

    @Autowired
    private ApplyServiceImpl applyService;

    @PostMapping("")
    public Response<Object> saveApply(HttpServletRequest request, @RequestBody ApplyReq applyReq){
        Apply apply = Apply.builder()
                .lectureId(applyReq.lectureId)
                .who(applyReq.who)
                .status("cm")
                .build();

        applyService.apply(apply);

        return Response.builder()
                .message("create apply")
                .url(request.getRequestURI())
                .build();
    }
}
