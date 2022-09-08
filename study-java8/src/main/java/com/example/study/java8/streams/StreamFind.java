package com.example.study.java8.streams;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * String find 查找
 */
public class StreamFind {
    public static void main(String[] args) {
        Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});

        //1、findFirst  查找第一个
        Optional<Integer> firstOptional = stream.filter(i -> i % 2 == 0).findFirst();
        System.out.println(firstOptional);


        //2、findAny  查找任意一个
        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        Optional<Integer> anyOptional = stream.filter(i -> i % 2 == 0).findAny();
        System.out.println(anyOptional.get());

        //3、没找到时，使用get（）会直接抛出异常提示信息，会提示错误：No value present
        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        Optional<Integer> noNumOptional = stream.filter(i -> i == 11).findAny();
//        System.out.println(noNumOptional.get());
        //抛出异常提示：No value present

        //4、没找到时，Optional输出，不抛异常：Optional.empty
        // Optional.empty
        System.out.println(noNumOptional);

        //5、orElse  如果没查找返回给定的值
        //原始写法
        int findValueResult = findDifineValue(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, -1, i -> i == 9);
        System.out.println(findValueResult);
        //  orElse写法  如果没查找返回给定的值
        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        System.out.println(noNumOptional.orElse(-1));

        //6、isPresent 判断是否存在，直接返回boolean值
        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        boolean isPresent = stream.filter(i->i==4).findAny().isPresent();
        System.out.println(isPresent);

        //7、存在就打印出来,没有则不打印
        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        stream.filter(i->i==6).findAny().ifPresent(System.out::println);

        //8、还可以进行二次过滤
        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        //先Stream的filter过滤,然后得到Optional,再用Optional的filter过滤
        stream.filter(i->i>8).findAny().filter(i->i<10).ifPresent(System.out::println);

    }

    /**
     * 原始写法，查询数组中是否包含指定值，没有返回默认值
     * @param values
     * @param defaultValue
     * @param predicate
     * @return
     */
    public static  int findDifineValue(Integer[] values, int defaultValue, Predicate<Integer> predicate){
        for(int i : values){
            if(predicate.test(i)){
                return i;
            }
        }
        return defaultValue;
    }
}
