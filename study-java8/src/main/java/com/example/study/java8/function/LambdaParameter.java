package com.example.study.java8.function;

/**
 * lambda表达式 作用范围，注意事项
 */
public class LambdaParameter {
    public static void main(String[] args) {
        int i =0;

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                //i会报错提示：
                //Variable 'i' is accessed from within inner class, needs to be final or effectively final
               i++;
            }
        };
        i++;

        //Lambda表达式
        Runnable runnable1 = ()->{
            //i同样报错提示：
            //Variable used in lambda expression should be final or effectively final
           System.out.println(i);
        };
        i++;
    }
}
