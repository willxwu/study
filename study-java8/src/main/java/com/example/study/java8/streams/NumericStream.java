package com.example.study.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Stream Numeric：
 * mapToInt、mapToLong、mapToDouble：可以将包装类拆箱成基本数据类型，节约内存空间
 * mapToObj：可以将数据直接装成对象，代码量少很多。
 */
public class NumericStream {
    public static void main(String[] args) {
        //方式一：reduce实现
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10,6,5,4,3,2,1);
        list.stream().reduce(Integer::sum).ifPresent(System.out::println);

        //方式二：mapToInt
        list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10,6,5,4,3,2,1);
        IntStream mapToInt = list.stream().mapToInt(i -> i.intValue());
        int sum = mapToInt.sum();
        System.out.println(sum);

        //方式三：mapToInt后用reduce实现
        list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10,6,5,4,3,2,1);
        IntStream intStream = list.stream().mapToInt(i -> i.intValue());
        int reduce = list.stream().mapToInt(i -> i.intValue()).reduce(0, (i, j) -> i + j);
        System.out.println(reduce);

        //区别：直接使用reduce实现，使用的是包装类Integer，用mapToInt则可以转成int计算，占用内存更小。


        System.out.println("==================================");


        //实列：
        // 1--100，中满足勾股定律的数字 3\4\5  9,并返回成一个数组
        int a =9;

        //1、原始分步骤写法:
        //创建1-100的数字
        IntStream rangeClosed = IntStream.rangeClosed(1, 100);
        //找到满足勾股定律的数字
        Stream<Integer> boxed = rangeClosed.filter(i -> Math.sqrt(a * a + i * i) % 1 == 0).boxed();
        //将数字转变成int数组返回
        Stream<int[]> stream = boxed.map(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)});
        //输出数组数据
        stream.forEach(array->System.out.println("a="+array[0]+",b="+array[1]+",c="+array[2]));
        System.out.println("============================================");

        //2、原始写法，程序简化后
        IntStream.rangeClosed(1, 100)
                .filter(i->Math.sqrt(a*a + i*i)%1==0)
                .boxed()
                .map(b->new int[]{a,b,(int)Math.sqrt(a*a+b*b)})
                .forEach(array->System.out.println("a="+array[0]+",b="+array[1]+",c="+array[2]));

        System.out.println("============================================");



        //3、使用mapToObj，更精简代码，直接将满足条件数据，转成一个数组
        IntStream.rangeClosed(1, 100)
                .filter(i->Math.sqrt(a*a + i*i)%1==0)
                .mapToObj(b->new int[]{a,b,(int)Math.sqrt(a*a+b*b)})
                .forEach(array->System.out.println("a="+array[0]+",b="+array[1]+",c="+array[2]));
    }
}
