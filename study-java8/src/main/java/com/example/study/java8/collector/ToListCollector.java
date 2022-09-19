package com.example.study.java8.collector;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * 自定义Collector
 * T:元素类型
 * List<T>:要创建的类型
 * List<T>:最后要返回的类型
 */
public class ToListCollector<T> implements Collector<T, List<T>, List<T>> {
    private void log(final String log) {
        System.out.println(Thread.currentThread().getName()+"-"+log);
    }

    //一定时可变的supplier，不是固定值
    @Override
    public Supplier<List<T>> supplier() {
        log("supplier");
        return ArrayList::new;
    }

    //要进行的操作
    @Override
    public BiConsumer<List<T>, T> accumulator() {
        log("accumulator");
        return List::add;
    }

    //将结果整合
    @Override
    public BinaryOperator<List<T>> combiner() {
        log("combiner");
        return (list1,list2)->{
            list1.addAll(list2);
            return list1;
        };
    }

    //返回结果
    @Override
    public Function<List<T>, List<T>> finisher() {
        log("finisher");
//        return t->t;
        return Function.identity();
    }

    //特征值:CONCURRENT-并行,UNORDERED-排序，IDENTITY_FINISH-入参就出参
    @Override
    public Set<Characteristics> characteristics() {
        log("characteristics");
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH, Characteristics.CONCURRENT));
    }
}
