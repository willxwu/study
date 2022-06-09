package com.example.study.concurrency.concurrency.atomic;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @description: AtomicIntegerFieldUpdater,原子性修改
 * @author: <a href="mailto:batis@foxmail.com">清风</a>
 * @date: 2022/4/20 21:17
 * @version: 1.0
 */
@Slf4j
public class DemoAtomicIntegerFieldUpdater {

    private static AtomicIntegerFieldUpdater<DemoAtomicIntegerFieldUpdater> updater = AtomicIntegerFieldUpdater.newUpdater(DemoAtomicIntegerFieldUpdater.class, "count");

    @Getter
    public volatile int count = 100;

    private static DemoAtomicIntegerFieldUpdater demoAtomicIntegerFieldUpdater = new DemoAtomicIntegerFieldUpdater();

    public static void main(String[] args) {
        if(updater.compareAndSet(demoAtomicIntegerFieldUpdater, 100, 200)) {
            log.info("updater succcess1,{}", demoAtomicIntegerFieldUpdater.getCount());
        }

        if(updater.compareAndSet(demoAtomicIntegerFieldUpdater, 100, 200)) {
            log.info("updater succcess2,{}", demoAtomicIntegerFieldUpdater.getCount());
        }else {
            log.info("updater fail,{}", demoAtomicIntegerFieldUpdater.getCount());
        }
    }
}
