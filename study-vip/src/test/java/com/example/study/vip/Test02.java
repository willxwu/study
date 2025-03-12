package com.example.study.vip;

import com.example.study.vip.com.example.study.vip.entity.UserEntity;
import org.apache.catalina.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class Test02 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException {
        Class<?> aClass = Class.forName("com.example.study.vip.com.example.study.vip.entity.UserEntity");
        UserEntity userEntity = (UserEntity) aClass.newInstance();

        Field field = aClass.getDeclaredField("address");
        field.set(userEntity, "四川成都");

        System.out.println(userEntity.toString());
    }
}
