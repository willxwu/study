package com.example.study.vip;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test06 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<String> arrayList = new ArrayList<>();
        arrayList.add("chengdu");

        Class<? extends ArrayList> aClass = (Class<? extends ArrayList>) arrayList.getClass();

        Method add = aClass.getDeclaredMethod("add", Object.class);
        add.setAccessible(true);
        add.invoke(arrayList, 20);
        System.out.println(arrayList.size());

        Iterator<String> iterator = arrayList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
