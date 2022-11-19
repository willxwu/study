package com.example.study.java8.method;

/**
 * default使用
 */
public class DefaultAction {

    public static void main(String[] args) {
        A a = ()->10;
        System.out.println(a.size());
        System.out.println(a.isEmpty());
    }

    public interface A{
        int size();
        //判断容器是否为空
        default boolean isEmpty(){
            return size()==0;
        }
    }
}
