package com.example.study.concurrency.concurrency.finals;

import com.example.study.concurrency.concurrency.annotation.ThreadSafety;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.Map;

/**
 * @description: Collections.unmodifiableXXXXX,值是不能修改的，但是是线程安全的
 * @author: <a href="mailto:batis@foxmail.com">清风</a>
 * @date: 2022/4/22 21:12
 * @version: 1.0
 */
@Slf4j
@ThreadSafety
public class DemoCollections {

    private static Map<Integer, Integer> map = Maps.newHashMap();

    static {
        map.put(1, 2);
        map.put(3, 4);
        map.put(5, 6);
        map = Collections.unmodifiableMap(map);
    }

    public static void main(String[] args) {
        map.put(1, 8);
        log.info("{}", map.get(1));
    }

}
