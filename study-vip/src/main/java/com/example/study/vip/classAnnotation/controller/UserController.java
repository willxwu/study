package com.example.study.vip.classAnnotation.controller;

import com.example.study.vip.classAnnotation.annotation.MyAnnotation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@MyAnnotation
public class UserController {

    @MyAnnotation
    private String hi;

//    private RateLimiter rateLimiter = RateLimiter.create(1.0);

    @GetMapping("/hi")
    @MyAnnotation(name="hi", age=1.0)
    public String hi(String ab){
//        boolean b = rateLimiter.tryAcquire();
//        if(!b){
//            return "限流了";
//        }
        return "My Annotation and RateLimiter";
    }

    @GetMapping("/hi2")
    @MyAnnotation(name="hi2", age=7.0)
    public String hi2(){
        return "My Annotation and RateLimiter2";
    }
}
