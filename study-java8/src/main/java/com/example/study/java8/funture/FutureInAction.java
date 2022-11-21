package com.example.study.java8.funture;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 自定义模拟future，理解Future的使用。
 */
public class FutureInAction {
    public static void main(String[] args) throws InterruptedException {
/*        Funture<String> funture = invoke(() -> {
            try {
                //模拟操作计算很长时间
                Thread.sleep(10000);
                return "I'm finished";
            } catch (Exception e) {
                e.printStackTrace();
                return "Error";
            }
        });
        //操作计算很长时间，还没操作计算完成，只返回了future，虽然此时返回值为null，但是可以接着执行官其它操作,不会阻塞后续操作。
        System.out.println(funture.get());
        System.out.println(funture.get());
        System.out.println(funture.get());

        //知道操作计算完成后，将值返回
        while (!funture.isDone()) {
            Thread.sleep(10);
        }
        System.out.println(funture.get());*/


        //以前没有future，阻塞方式测试
        String str = block(() -> {
            try {
                //模拟操作计算很长时间
                Thread.sleep(10000);
                return "I'm finished";
            } catch (Exception e) {
                e.printStackTrace();
                return "Error";
            }
        });
        //这里就会阻塞等返回结果，再执行下面的其他操作。
        System.out.println(str);
    }

    private static <T> Funture<T> invoke(Callable<T> callable) {
        AtomicReference<T> result = new AtomicReference<>();
        AtomicBoolean finished = new AtomicBoolean(false);

        Thread t = new Thread(() -> {
            T value = callable.action();
            result.set(value);
            finished.set(true);
        });
        t.start();

        Funture funture = new Funture() {
            @Override
            public Object get() {
                return result.get();
            }

            @Override
            public boolean isDone() {
                return finished.get();
            }
        };
        return funture;
    }


    //最早的没有future，实现方式
    private static <T> T block(Callable<T> callable) {
        return callable.action();
    }


    private interface Funture<T> {
        T get();

        boolean isDone();
    }

    private interface Callable<T> {
        T action();
    }
}
