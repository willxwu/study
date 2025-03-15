package com.example.study.vip.thread.aop;

import com.example.study.vip.thread.annotation.MyLogAnnotaion;
import com.example.study.vip.thread.async.LogAync;
import lombok.SneakyThrows;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class MyConAop {

    @Autowired
    private LogAync logAync;

    @Pointcut(value = "@annotation(com.example.study.vip.thread.annotation.MyLogAnnotaion)")
    public void myCut(){};

//    @Before("myCut()")
//    public void before(){
//        System.out.println("======================方法前执行");
//        System.out.println("我是方法前执行主线程,线程名:" + Thread.currentThread().getName());
//    }

//    @Around(value = "myCut()")
//    public Object around(ProceedingJoinPoint joinPoint) {
//        try {
//            System.out.println("我是AOP主线程,线程名:" + Thread.currentThread().getName());
//
//            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//
//            String[] parameterNames = signature.getParameterNames();
//            System.out.println("参数名=" + parameterNames);
//
//            Object[] args = joinPoint.getArgs();
//            System.out.println("参数值=" + args);
//
//            Map<String, Object> map = new HashMap<>();
//            for (int i = 0; i < parameterNames.length; i++) {
//                map.put(parameterNames[i], args[i]);
//            }
//
//            logAync.recordLog(map);
//
//            MyLogAnnotaion myLogAnnotaion = signature.getMethod().getDeclaredAnnotation(MyLogAnnotaion.class);
//            String name = myLogAnnotaion.name();
//            double age = myLogAnnotaion.age();
//            System.out.println("方法上注解参数=" + name + age);
//
//            return joinPoint.proceed();
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//            System.out.println("AOP出事故了=" + throwable.getMessage());
//            return "AOP出事故了=" + throwable.getMessage();
//        }
//    }

    @Around(value = "myCut()")
    public void around2(ProceedingJoinPoint joinPoint) {
        System.out.println("我是AOP主线程,线程名:" + Thread.currentThread().getName());
        try {


            new Thread(()->{
                System.out.println("我是新主线程,线程名:" + Thread.currentThread().getName());

                MethodSignature signature = (MethodSignature) joinPoint.getSignature();

                String[] parameterNames = signature.getParameterNames();
                System.out.println("参数名=" + parameterNames);

                Object[] args = joinPoint.getArgs();
                System.out.println("参数值=" + args);

                Map<String, Object> map = new HashMap<>();
                for (int i = 0; i < parameterNames.length; i++) {
                    map.put(parameterNames[i], args[i]);
                }

                logAync.recordLog(map);

                MyLogAnnotaion myLogAnnotaion = signature.getMethod().getDeclaredAnnotation(MyLogAnnotaion.class);
                String name = myLogAnnotaion.name();
                double age = myLogAnnotaion.age();
                System.out.println("方法上注解参数=" + name + age);

                try {
                    joinPoint.proceed();
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                    System.out.println("目标方法出错了。。。"+throwable.getMessage());
                }
            }).start();

        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("AOP出事故了=" + throwable.getMessage());
        }
    }

//    @After("myCut()")
//    public void ager(){
//        System.out.println("方法后执行===========================");
//        System.out.println("我是方法后执行主线程,线程名:" + Thread.currentThread().getName());
//    }

//    @AfterThrowing(value="myCut()", throwing = "ex")
//    public void thr(Exception ex){
//        System.out.println("目标方法异常====异常通知"+ex.getMessage());
//        System.out.println("我是异常主线程,线程名:" + Thread.currentThread().getName());
//    }
}
