package com.example.study.java8.collector;

import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Stream parallel并行执行
 * 实列：求10次，1~100000000的和，看时间效率。
 */
public class ParallelProcessing {
    public static void main(String[] args) {
        //获取电脑CPU核数
        System.out.println("当前电脑CPU核数= " + Runtime.getRuntime().availableProcessors());
        System.out.println("The best process time(normalAdd)=> " + measureSumPerformance(ParallelProcessing::normalAdd, 100_000_000) + " MS");
//        System.out.println("The best process time(iterateStream1)=> " + measureSumPerformance(ParallelProcessing::iterateStream1, 100_000_000) + " MS");
//        System.out.println("The best process time(iterateStream2)=> " + measureSumPerformance(ParallelProcessing::iterateStream2, 100_000_000) + " MS");
//        System.out.println("The best process time(iterateStream3)=> " + measureSumPerformance(ParallelProcessing::iterateStream3, 100_000_000) + " MS");
        System.out.println("The best process time(iterateStream4)=> " + measureSumPerformance(ParallelProcessing::iterateStream4, 100_000_000) + " MS");
        System.out.println("The best process time(iterateStream5)=> " + measureSumPerformance(ParallelProcessing::iterateStream5, 100_000_000) + " MS");

    }


    private static long measureSumPerformance(Function<Long, Long> adder, long limist) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            Long startTimestamp = System.currentTimeMillis();
            long result = adder.apply(limist);
            long duration = System.currentTimeMillis() - startTimestamp;
//            System.out.println("The result of sum=>"+result);
            if (duration < fastest) fastest = duration;
        }

        return fastest;
    }

    /**
     * 1、函数式编程实现：没有使用并行执行
     *
     * @param limit
     * @return
     */
    public static long iterateStream1(long limit) {
        return Stream.iterate(1L, i -> i + 1).limit(limit).reduce(0L, Long::sum);
    }

    /**
     * 2、函数式编程实现-进化：使用并行执行，要进行拆箱装箱
     *
     * @param limit
     * @return
     */
    public static long iterateStream2(long limit) {
        return Stream.iterate(1L, i -> i + 1).parallel().limit(limit).reduce(0L, Long::sum);
    }

    /**
     * 3、函数式编程实现-再次进化：只用并行执行，不进行拆箱装箱
     *
     * @param limit
     * @return
     */
    public static long iterateStream3(long limit) {
        return Stream.iterate(1L, i -> i + 1).mapToLong(Long::longValue).parallel().limit(limit).reduce(0L, Long::sum);
    }

    /**
     * 4、函数式编程实现-再次再次进化：只用并行执行
     *
     * @param limit
     * @return
     */
    public static long iterateStream4(long limit) {
        return LongStream.rangeClosed(1L, limit).parallel().reduce(0L, Long::sum);
    }

    /**
     * 5、函数式编程实现-再次再次再次进化
     *
     * @param limit
     * @return
     */
    public static long iterateStream5(long limit) {
        return LongStream.rangeClosed(1L, limit).parallel().sum();
    }

    /**
     * 原始写法
     *
     * @param limit
     * @return
     */
    public static long normalAdd(long limit) {
        long result = 0L;
        for (long i = 1; i < limit; i++) {
            result++;
        }
        return result;
    }
}
