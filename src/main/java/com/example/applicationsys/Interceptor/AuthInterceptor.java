package com.example.applicationsys.Interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
@Slf4j
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(1);
        HttpSession httpSession = request.getSession();

        // 로그인 여부 확인
        /*if (httpSession.getAttribute("member") == null) {
            log.warn("current user is not logged");
            response.sendRedirect("/mypage/user/login");
            return false;
        }*/

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println(2);
        System.out.println(response.getStatus());

        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
