package com.example.study.vip.classAnnotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test04 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        Class<?> aClass = Class.forName("com.example.study.vip.classAnnotation.entity.UserEntity");
        Object o = aClass.newInstance();
        Method say = aClass.getDeclaredMethod("say");
        say.setAccessible(true);
        Object invoke = say.invoke(o);
        System.out.println(invoke);
    }
}
