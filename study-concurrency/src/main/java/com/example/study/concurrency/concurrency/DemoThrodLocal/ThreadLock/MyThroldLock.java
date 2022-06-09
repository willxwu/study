package com.example.study.concurrency.concurrency.DemoThrodLocal.ThreadLock;

/**
 * @description: 使用ThrodLock的线程封闭，实现在一个线程种数据共享
 * @author: <a href="mailto:batis@foxmail.com">清风</a>
 * @date: 2022/4/22 22:56
 * @version: 1.0
 */
public class MyThroldLock {

    private final static ThreadLocal<Long> requestholder = new ThreadLocal<>();

    //用ThreadLock提供的set方法，向ThreadLock中放入共享数据id
    //一般在实际接口处理前调用
    public  static void add(Long id) {
        requestholder.set(id);
    }

    //用ThreadLock提供的get方法获取ThreadLock中共享的数据
    public static Long get() {
        return requestholder.get();
    }

    //用ThreadLock提供的remove方法移除共享数据，不然容易导致内存溢出
    //一般在接口真正处理完后调用
    public static void remove() {
        requestholder.remove();
    }
}
