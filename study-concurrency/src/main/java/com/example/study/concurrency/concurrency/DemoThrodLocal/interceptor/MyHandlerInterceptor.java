package com.example.study.concurrency.concurrency.DemoThrodLocal.interceptor;

import com.example.study.concurrency.concurrency.DemoThrodLocal.ThreadLock.MyThroldLock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description: 自定义HandlerInerceptor
 * @author: <a href="mailto:batis@foxmail.com">清风</a>
 * @date: 2022/4/22 22:28
 * @version: 1.0
 */
@Slf4j
@Component
public class MyHandlerInterceptor implements HandlerInterceptor {


    //接口处理之前
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("进入controller之前的preHanler方法。。。。");
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("这个是干嘛的呢。。。");
    }

    //接口处理之后
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("之后的方法。。。。afterCompletion,MyThroldLock.remove()");
        MyThroldLock.remove();
        return;
    }
}
