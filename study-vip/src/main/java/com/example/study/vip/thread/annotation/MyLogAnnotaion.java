package com.example.study.vip.thread.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface MyLogAnnotaion {

    String name() default "";

    double age() default 1;
}
