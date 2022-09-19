package com.example.study.java8.collector;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;

/**
 * 使用自定义Collector测试
 */
public class CustomToListCollector {
    public static void main(String[] args) {
        String[] arrs = new String[]{"chinese","japanse","english","freach","Korean"};
        //测试
        //对应接口中的：
        //Supplier<A> supplier(), BiConsumer<A, T> accumulator(),Function<A, R> finisher();
        Collector<String, List<String>, List<String>> collector = new ToListCollector<String>();
        List<String> list = Arrays.stream(arrs).filter(s -> s.length() > 6).collect(collector);
        System.out.println(list);

        System.out.println("================================");

        //parallelStream（），并行使用测试
        List<String> parallelList = Arrays.asList(new String[]{"chinese", "japanse", "english", "freach", "Korean"})
                .parallelStream()
                .filter(s -> s.length() > 6)
                .collect(collector);
        System.out.println(parallelList);
    }
}
