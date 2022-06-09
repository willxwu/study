package com.example.study.concurrency.concurrency.finals;

import com.example.study.concurrency.concurrency.annotation.UnThreadSafety;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @description: 不可变对象 final修饰
 * @author: <a href="mailto:batis@foxmail.com">清风</a>
 * @date: 2022/4/22 20:35
 * @version: 1.0
 */
@Slf4j
@UnThreadSafety
public class DemoFinal {
    //普通类型，final修饰后，修改直接提示错误
    private final static Integer a =1;
    //普通类型，final修饰后，修改直接提示错误
    private final static String b = "hello";
    //final修饰后不能在执行新的对象
    private final static Map<Integer, Integer> map = Maps.newHashMap();

    static {
        map.put(1, 2);
        map.put(2, 3);
        map.put(4, 5);
    }

    public static void main(String[] args) {
        //指向新的对象，直接报错
//        map = new Maps.newHashMap();

        //值可以修改，但是线程不安全
        map.put(1, 6);
        log.info("{}", map.get(1));
        // 输出结果：- 6
    }

    //fina修饰形参，传入后也不能修改
    public void test(final int a) {
        //报错
//        a =2;
    }

}
