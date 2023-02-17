package com.example.applicationsys.config;

import com.example.applicationsys.Interceptor.AuthInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig  implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /** 주석을 통해 일부로 로그인이 없어도 되도록 세팅 **/
        registry.addInterceptor(new AuthInterceptor())
                .addPathPatterns("/api/apply"); // 해당 경로에 접근하기 전에 인터셉터가 가로챈다.
                //.addPathPatterns("/api/notice/all") // 해당 경로에 접근하기 전에 인터셉터가 가로챈다.
    }
}
