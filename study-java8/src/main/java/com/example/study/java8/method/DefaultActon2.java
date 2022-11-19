package com.example.study.java8.method;

/**
 * 方法调用问题解惑，优先调用声明更具体的方法
 */
public class DefaultActon2 {

    public void confuse(Object obj){
        System.out.println("Object");
    }

    public void confuse(int[] i){
        System.out.println("int[]");
    }

    public static void main(String[] args) {
        DefaultActon2 action = new DefaultActon2();
        action.confuse(null);

        int [] arr = null;
        Object obj = arr;
        action.confuse(obj);
    }
}
