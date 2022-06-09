package com.example.study.concurrency.concurrency.unSafePublish;

import lombok.extern.slf4j.Slf4j;

/**
 * @description: 对象溢出
 * @author: <a href="mailto:batis@foxmail.com">清风</a>
 * @date: 2022/4/21 21:53
 * @version: 1.0
 */
@Slf4j
public class Escape {

    private int thisCanBeEascpe = 0;

    public Escape() {
        new InnerClass();
    }

    private class InnerClass {

        public InnerClass() {
            log.info("{}", Escape.this.thisCanBeEascpe);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }
}
