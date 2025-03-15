package com.example.study.vip.classAnnotation.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD,ElementType.TYPE,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface MyAnnotation {
    public String name() default "";
    public double age() default 1.0;
}
