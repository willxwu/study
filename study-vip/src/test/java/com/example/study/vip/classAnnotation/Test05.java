package com.example.study.vip.classAnnotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test05 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        Class<?> aClass = Class.forName("com.example.study.vip.classAnnotation.entity.UserEntity");
        Object o = aClass.newInstance();
        Method count = aClass.getDeclaredMethod("count", String.class, Integer.class);
        count.setAccessible(true);
        Object invo = count.invoke(o, "王五", 80);
        System.out.println(invo);
    }
}
