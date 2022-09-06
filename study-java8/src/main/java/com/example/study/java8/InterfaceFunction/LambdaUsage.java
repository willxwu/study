package com.example.study.java8.InterfaceFunction;

/**
 * lambda表达式用法
 */
public class LambdaUsage {
    public static void main(String[] args) {
        Runnable runnable1 = ()-> System.out.println("hello");

        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        };

        process(runnable1);
        process(runnable2);
        process(()-> System.out.println("hello"));
    }

    public static void process(Runnable runnable){
        runnable.run();
    }
}
