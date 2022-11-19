package com.example.study.java8.method;

/**
 * 1、类的优先级最高
 * 2、上一级接口，不管上一级接口有多少个类
 */
public class DefaultAction3 {

    public static void main(String[] args) {
        A c = new C();
        c.hello();
    }

    public interface A{
        default void hello(){
            System.out.println("A-Hello");
        }
    }

    public interface B extends A{
        @Override
        default void hello(){
            System.out.println("B-Hello");
        }
    }

    public static class C implements B , A{
        @Override
        public void hello() {
            System.out.println("C-Hello");
        }
    }
}
