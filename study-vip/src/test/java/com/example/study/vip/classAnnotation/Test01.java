package com.example.study.vip.classAnnotation;

import com.example.study.vip.classAnnotation.entity.UserEntity;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Test01 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> aClass = Class.forName("com.example.study.vip.classAnnotation.entity.UserEntity");
        Constructor<?> constructor = aClass.getDeclaredConstructor(String.class, Integer.class);
        UserEntity userEntity = (UserEntity) constructor.newInstance("张三", 18);
        System.out.println(userEntity.toString());
    }
}
