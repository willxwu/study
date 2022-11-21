package com.example.study.java8.funture;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 实现一个异步基于事件回调的Future程序
 */
public class FutureInAction3 {
    public static void main(String[] args) {
        Future<String> future = invoke(() -> {
            try {
                Thread.sleep(10000L);
                return "I'm finished.";
            } catch (InterruptedException e) {
                return "I'm Error.";
            }
        });

        //注册一个事件
        future.setCompletable(new Completable<String>() {
            @Override
            public void completable(String s) {
                System.out.println(s);
            }

            @Override
            public void excetion(Throwable cause) {
                System.out.println("Error");
                cause.printStackTrace();
            }
        });

        //下面就可以执行其它逻辑了。。。
        System.out.println("。。。。。。。。。");
        System.out.println(future.get());
        System.out.println(future.get());
    }

    private static <T> Future<T> invoke(Callable<T> callable) {
        AtomicReference<T> result = new AtomicReference<>();
        AtomicBoolean finished = new AtomicBoolean(false);

        Future future = new Future() {
            private Completable<T> completable;

            @Override
            public Object get() {
                return result.get();
            }

            @Override
            public boolean isDone() {
                return finished.get();
            }

            @Override
            public void setCompletable(Completable completable) {
                this.completable = completable;
            }

            @Override
            public Completable getCompletable() {
                return completable;
            }
        };

        Thread t = new Thread(() -> {
            try {
                T value = callable.action();
                result.set(value);
                finished.set(true);
                if (future.getCompletable() != null) {
                    //调用回调函数
                    future.getCompletable().completable(value);
                }
            } catch (Exception cause) {
                if (future.getCompletable() != null) {
                    future.getCompletable().excetion(cause);
                }
            }
        });
        t.start();


        return future;
    }

    /**
     * 自定义的Future
     *
     * @param <T>
     */
    private interface Future<T> {
        T get();

        boolean isDone();

        void setCompletable(Completable<T> completable);

        Completable<T> getCompletable();
    }

    private interface Callable<T> {
        T action();
    }

    /**
     * 回调接口
     *
     * @param <T>
     */
    private interface Completable<T> {
        /**
         * 执行完后，调用的回调函数
         *
         * @param t
         */
        void completable(T t);

        /**
         * 执行过程中出现的异常，直接传入需要抛出的异常回调。
         *
         * @param cause
         */
        void excetion(Throwable cause);
    }
}
