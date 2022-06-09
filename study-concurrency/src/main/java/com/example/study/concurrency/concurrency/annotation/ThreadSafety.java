package com.example.study.concurrency.concurrency.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 安全的线程类
 */
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.TYPE})
public @interface ThreadSafety {

    String value() default "";
}
