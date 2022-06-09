package com.example.study.concurrency.concurrency.DemoThrodLocal.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @description: 自定义WebMVCConfig
 * @author: <a href="mailto:batis@foxmail.com">清风</a>
 * @date: 2022/4/22 22:31
 * @version: 1.0
*/
@Configuration
public class MyWebMvcConfigurerAdapter implements WebMvcConfigurer {

    @Autowired
    MyHandlerInterceptor myHandlerInterceptor;

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myHandlerInterceptor).addPathPatterns("/**");
    }
}
