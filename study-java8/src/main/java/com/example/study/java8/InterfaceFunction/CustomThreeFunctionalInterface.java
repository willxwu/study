package com.example.study.java8.InterfaceFunction;

/**
 * 自定义多个参数函数接口，创建对象
 */
@FunctionalInterface
public interface CustomThreeFunctionalInterface<T, U, K, R> {
    R apply(T t, U u, K k);
}
