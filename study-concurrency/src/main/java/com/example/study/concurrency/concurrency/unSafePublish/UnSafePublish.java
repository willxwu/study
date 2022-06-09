package com.example.study.concurrency.concurrency.unSafePublish;

import com.example.study.concurrency.concurrency.annotation.UnThreadSafety;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @description: 安全发布,这个例子是线程不安全的
 * @author: <a href="mailto:batis@foxmail.com">清风</a>
 * @date: 2022/4/21 21:45
 * @version: 1.0
 */
@Slf4j
@UnThreadSafety
public class UnSafePublish {
    private String[] states = {"a", "b", "c"};

    public String[] getStates() {
        return states;
    }

    public static void main(String[] args) {
        UnSafePublish unSafePublish = new UnSafePublish();
        log.info("{}", Arrays.toString(unSafePublish.getStates()));

        unSafePublish.getStates()[0] = "d";
        log.info("{}", Arrays.toString(unSafePublish.getStates()));

    }
}
