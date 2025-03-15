package com.example.study.vip.classAnnotation.aop;

import com.example.study.vip.classAnnotation.annotation.MyAnnotation;
import com.google.common.util.concurrent.RateLimiter;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

@Component
@Aspect
public class MyAOP {

    private ConcurrentHashMap<String, RateLimiter> ratelimiters = new ConcurrentHashMap<String, RateLimiter>();

    @Before(value="@annotation(com.example.study.vip.classAnnotation.annotation.MyAnnotation)")
    public void Before(){
        System.out.println("前置通知");
    }

    @After(value = "@annotation(com.example.study.vip.classAnnotation.annotation.MyAnnotation)")
    public void agter(){
        System.out.println("后置通知");
    }

    @Around(value = "@annotation(com.example.study.vip.classAnnotation.annotation.MyAnnotation)")
    public Object around(ProceedingJoinPoint joinPoint){
        try {
            Signature signature = joinPoint.getSignature();
            MethodSignature sn = (MethodSignature) signature;
//            Method method = sn.getMethod();
//            String[] parameterNames = sn.getParameterNames();
//            for (String s : parameterNames
//                 ) {
//                System.out.println(s);
//            };
            MyAnnotation declaredAnnotation = sn.getMethod().getDeclaredAnnotation(MyAnnotation.class);
            String name = declaredAnnotation.name();
            double age = declaredAnnotation.age();
            RateLimiter o = (RateLimiter) ratelimiters.get(name);
            if(o==null){
                o=RateLimiter.create(age);
                ratelimiters.put(name,o);
            }
            boolean b = o.tryAcquire();
            if(!b){
                return "限流了哦";
            }

            System.out.println("目标方法前");
            Object proceed = joinPoint.proceed();
            System.out.println("目标方法后");
            return proceed;
        }catch (Throwable throwable) {
            return "系统异常";
        }

    }

}
