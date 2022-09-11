package com.example.study.java8.streams.demo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

/**
 * 交易员进行交易
 */
public class StreamInAction {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        //1、交易年未2011年，并按交易金额排序
        transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(toList())
                .forEach(System.out::println);

        System.out.println("===================================");
        //2、获取城市并去重
        transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);

        System.out.println("===================================");
        //3、获取交易员所在城市为“Cambridge”的交易员，去重，并按交易员名字排序
        transactions.stream()
                .map(t->t.getTrader())
                .filter(g->"Cambridge".equals(g.getCity()))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .forEach(System.out::println);

        System.out.println("===================================");
        //4、获取所有交易员名字，并排序,拼接成字符串
        String result = transactions.stream()
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (str1, str2) -> str1 + "\t" +str2);
        System.out.println(result);

        System.out.println("===================================");
        //5、交易员城市是否有在Milan的
        boolean anyMatch = transactions.stream()
                .anyMatch(t -> "Milan".equals(t.getTrader().getCity()));
        System.out.println(anyMatch);
        //或者
        System.out.println("===================================");
        boolean anyMatchMap = transactions.stream()
                .map(t -> t.getTrader())
                .anyMatch(n -> "Milan".equals(n.getCity()));
        System.out.println(anyMatchMap);

        System.out.println("===================================");
        //6、打印所有交易值，且交易员所在城市是Milan的。
        transactions.stream()
                .filter(t->"Cambridge".equals(t.getTrader().getCity()))
                .map(Transaction::getValue)
                .sorted()
                .forEach(System.out::println);

        //7、找最大的值
        System.out.println("===================================");
        Optional<Integer> maxValue = transactions.stream()
                .map(Transaction::getValue)
                .reduce((i, j) -> i > j ? i : j);
        System.out.println(maxValue.get());

        //8、找最小的值
        System.out.println("===================================");
        Optional<Integer> minValue = transactions.stream().map(t -> t.getValue()).reduce(Integer::min);
        System.out.println(minValue.get());
    }
}
