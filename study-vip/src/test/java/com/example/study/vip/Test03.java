package com.example.study.vip;

import com.example.study.vip.com.example.study.vip.entity.UserEntity;

import java.lang.reflect.Field;

public class Test03 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException {
        Class<?> aClass = Class.forName("com.example.study.vip.com.example.study.vip.entity.UserEntity");
        UserEntity userEntity = (UserEntity) aClass.newInstance();
        Field userAgeField = aClass.getDeclaredField("userAge");
        userAgeField.setAccessible(true);
        userAgeField.set(userEntity, 20);
        System.out.println(userEntity.toString());
    }
}
