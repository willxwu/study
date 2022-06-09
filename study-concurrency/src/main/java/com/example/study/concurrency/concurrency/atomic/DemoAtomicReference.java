package com.example.study.concurrency.concurrency.atomic;

import com.example.study.concurrency.concurrency.annotation.ThreadSafety;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @description: AtomicReference
 * @author: <a href="mailto:batis@foxmail.com">清风</a>
 * @date: 2022/4/20 21:09
 * @version: 1.0
 */
@Slf4j
@ThreadSafety
public class DemoAtomicReference {

    public static AtomicReference<Integer> count = new AtomicReference<>(0);

    public static void main(String[] args) {

        count.compareAndSet(0, 2);
        count.compareAndSet(0, 1);
        count.compareAndSet(1, 3);
        count.compareAndSet(2, 4);
        count.compareAndSet(3, 5);

        log.info("count结果为【{}】",count.get());
    }
}
