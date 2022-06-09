package com.example.study.concurrency.concurrency.DemoThrodLocal.controller;

import com.example.study.concurrency.concurrency.DemoThrodLocal.ThreadLock.MyThroldLock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: HandlerInterceptor 拦截器测试
 * @author: <a href="mailto:batis@foxmail.com">清风</a>
 * @date: 2022/4/22 22:25
 * @version: 1.0
 */
@RestController
@RequestMapping("/demo")
@Slf4j
public class ThreadLockController {

    @GetMapping("/myHandlerInterceptor")
    public String myHandlerInterceptorTest() {
        log.info("进入Controoler方法种。。。。。。");
        return "My HandlerInterceptor....,共享ThreadLock的变量为："+ MyThroldLock.get();
    }
}
