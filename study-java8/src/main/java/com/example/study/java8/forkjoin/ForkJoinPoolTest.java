package com.example.study.java8.forkjoin;

import java.util.concurrent.ForkJoinPool;

/**
 * ForkJoin:将一个任务，fork成多个现场执行，最后将结果join输出。
 * 两种实现：
 * 1、RecursiveTask：有返回值
 * 2、RecursiveAction：无返回值
 */
public class ForkJoinPoolTest {
    public static int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    public static void main(String[] args) {
        System.out.println("result=> " + calc());

        AccumulatorRecursiveTask task = new AccumulatorRecursiveTask(0, data.length, data);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Integer result = forkJoinPool.invoke(task);
        System.out.println("AccumulatorRecursiveTask result => " + result);

        AccumulatorRecursiveAction action = new AccumulatorRecursiveAction(0, data.length, data);
        forkJoinPool.invoke(action);
        System.out.println("AccumulatorRecursiveAction result => " + AccumulatorRecursiveAction.AccumulatorHelper.getResult());
    }

    public static int calc() {
        int result = 0;
        for (int i = 0; i < data.length; i++) {
            result += data[i];
        }
        return result;
    }
}
