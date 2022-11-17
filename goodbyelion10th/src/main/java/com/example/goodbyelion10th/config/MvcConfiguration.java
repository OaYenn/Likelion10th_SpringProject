package com.example.goodbyelion10th.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.TimeUnit;

@Configuration
public class MvcConfiguration implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**", "/users/**") // 1. '/'를 시작으로 하는 모든 요청을 다룸
                .addResourceLocations("classpath:/templates/", "classpath:/static/") // 2. 1번에 해당하는 요청을 처리할 자원을 찾을 위치를 나타냄
                .setCacheControl(CacheControl.maxAge(10, TimeUnit.MINUTES)); // 3. 요청에 대한 Cache를 10분으로 설정
    }
}
