package com.example.study.vip.thread.async;

import com.example.study.vip.thread.annotation.MyLogAnnotaion;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;

@Component
public class LogAync {

    @Async
    public void recordLog(Map<String, Object> map){
        System.out.println("我是日志主线程,线程名:" + Thread.currentThread().getName());
        Set<String> strings = map.keySet();
        for(String str : strings){
            Object o = map.get(str);
            System.out.println("日志种，参数"+str+"="+o);
        }
        System.out.println("日志记录成功");
    }
}
