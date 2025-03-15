package com.example.study.vip.classAnnotation;

import com.example.study.vip.classAnnotation.annotation.MyAnnotation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Test07 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ClassNotFoundException, NoSuchFieldException {
        Class<?> aClass = Class.forName("com.example.study.vip.classAnnotation.entity.UserEntity");
//        Method countMethod = aClass.getDeclaredMethod("count",String.class, Integer.class);
//        countMethod.setAccessible(true);
//        MyAnnotation declaredAnnotation = countMethod.getDeclaredAnnotation(MyAnnotation.class);
//        System.out.println(declaredAnnotation);

        Field userAgeFiled = aClass.getDeclaredField("userAge");
        userAgeFiled.setAccessible(true);
        MyAnnotation fieldAnnotation = userAgeFiled.getDeclaredAnnotation(MyAnnotation.class);
        System.out.println(fieldAnnotation);
    }
}
