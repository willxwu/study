package com.example.study.concurrency.concurrency.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 不推荐的写法
 */
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.TYPE})
public @interface UnRecommend {

    String value() default "";
}
