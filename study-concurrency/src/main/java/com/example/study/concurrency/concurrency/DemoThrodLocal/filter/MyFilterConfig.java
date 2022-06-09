package com.example.study.concurrency.concurrency.DemoThrodLocal.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: 将自定义的filter添加到spring拦截器中
 * @author: <a href="mailto:batis@foxmail.com">清风</a>
 * @date: 2022/4/22 23:37
 * @version: 1.0
 */
@Configuration
public class MyFilterConfig {

    @Bean
    public FilterRegistrationBean httpFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new HttpFilter());
        filterRegistrationBean.addUrlPatterns("/demo/*");
        return filterRegistrationBean;
    }
}
