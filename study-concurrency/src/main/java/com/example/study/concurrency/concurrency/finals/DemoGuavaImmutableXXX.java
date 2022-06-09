package com.example.study.concurrency.concurrency.finals;

import com.example.study.concurrency.concurrency.annotation.ThreadSafety;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

/**
 * @description: google Guava工具类实现对象不可变，线程安全，但是不能修改值
 * @author: <a href="mailto:batis@foxmail.com">清风</a>
 * @date: 2022/4/22 21:39
 * @version: 1.0
 */
@ThreadSafety
public class DemoGuavaImmutableXXX {
    //ImmutableList会提示不能修改,建议用这个
    private final static ImmutableList list = ImmutableList.of(2,3,5);

    //list不会提示不能修改
//    private final static List<Integer> list = ImmutableList.of(2,3,5);

    //set同理不能修改值
    private final static ImmutableSet set = ImmutableSet.copyOf(list);

    //map方式一，map用法有点区别，是key，value的形式                                           //（key1,value1,key2,value2,.......）
    private final static ImmutableMap<Integer, Integer> map = ImmutableMap.of(1,2,3,4,5,6);
    //map方法二,初始值有点不同
    private final static ImmutableMap<Integer, Integer> map2 = ImmutableMap.<Integer, Integer>builder().
            put(1, 2).put(3, 4).put(5, 6).build();

    public static void main(String[] args) {
        //提示错误：UnsupportedOperationException
//        list.add(4);

        //set同样会提示不能修改,提示".UnsupportedOperationException"
//        set.add(4);

        //map同理，不能修改值，否则也提示 UnsupportedOperationException
        map.put(3, 2);
    }
}
