package com.example.study.java8.forkjoin;

import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * 自定义Spliterator
 * 实列：将一段话按换行符分割成多个执行，并输出。
 */
public class SpliteratorInAction {
    //需要处理的数据
    private static String text = "The tryAdvance method feeds the Consumer with the Character in the String at the current index\n" +
            "position and increments this position. The Consumer passed as argument is an internal Java class\n" +
            "forwarding the consumed Character to the set of functions that have to be applied to it while\n" +
            "traversing the stream, which in this case is only a reducing function, namely, the accumulate method\n" +
            "of the WordCounter class. The tryAdvance method returns true if the new cursor position is less\n" +
            "than the total String length and there are further Characters to be iterated.\n" +
            "\uF0B7 The trySplit method is the most important one in a Spliterator because it’s the one defining the\n" +
            "logic used to split the data structure to be iterated. As you did in the compute method of the\n" +
            "RecursiveTask implemented in listing 7.1 (on how to use the fork/join framework), the first thing\n" +
            "you have to do here is set a limit under which you don’t want to perform further splits. Here, you use a\n" +
            "very low limit of 10 Characters only to make sure that your program will perform some splits with\n" +
            "the relatively short String you’re parsing, but in real-world applications you’ll have to use a higher\n" +
            "limit, as you did in the fork/join example, to avoid creating too many tasks. If the number of\n" +
            "remaining Characters to be traversed is under this limit, you return null to signal that no further\n" +
            "split is necessary. Conversely, if you need to perform a split, you set the candidate split position to the\n" +
            "half of the String chunk remaining to be parsed. But you don’t use this split position directly because\n" +
            "www.it-ebooks.info\n" +
            "231\n" +
            "you want to avoid splitting in the middle of a word, so you move forward until you find a blank\n" +
            "Character. Once you find an opportune split position, you create a new Spliterator that will traverse\n" +
            "the substring chunk going from the current position to the split one; you set the current position of\n" +
            "this to the split one, because the part before it will be managed by the new Spliterator, and then you\n" +
            "return it.\n" +
            "\uF0B7 The estimatedSize of elements still to be traversed is the difference between the total length of the\n" +
            "String parsed by this Spliterator and the position currently iterated.\n" +
            "\uF0B7 Finally, the characteristic method signals to the framework that this Spliterator is ORDERED\n" +
            "(the order is just the sequence of Characters in the String), SIZED (the value returned by the\n" +
            "estimatedSize method is exact), SUBSIZED (the other Spliterators created by the trySplit\n" +
            "method also have an exact size), NONNULL (there can be no null Characters in the String), and\n" +
            "IMMUTABLE (no further Characters can be added while parsing the String because the String\n" +
            "itself is an immutable class).";

    public static void main(String[] args) {
        //测试
        IntStream intStream = IntStream.rangeClosed(1, 10);
        Spliterator.OfInt spliterator = intStream.spliterator();
        Consumer<Integer> integerConsumer = i-> System.out.println(i);
        spliterator.forEachRemaining(integerConsumer);

        MySpliteratorText mySpliteratorText = new MySpliteratorText(text);
        //串行调用
//        Optional.ofNullable(mySpliteratorText.stream().count()).ifPresent(System.out::println);
//        mySpliteratorText.stream().forEach(System.out::println);

        //并行执行
        mySpliteratorText.stream().filter(s -> !"".equals(s)).forEach(System.out::println);
        mySpliteratorText.parallelStream().filter(s -> !"".equals(s)).forEach(System.out::println);
    }


    /**
     * 自定义Spliterator
     */
    static class MySpliteratorText {
        private final String[] data;

        public MySpliteratorText(String text) {
            Objects.requireNonNull(text, "Ths parameter can not be null");
            this.data = text.split("\n");
        }

        //暴露使用方法,穿行
        public Stream<String> stream() {
            return StreamSupport.stream(new MySpliterator(), false);
        }

        //暴露使用方法,并行
        public Stream<String> parallelStream() {
            return StreamSupport.stream(new MySpliterator(), true);
        }

        private class MySpliterator implements Spliterator<String> {

            private int start, end;

            public MySpliterator() {
                this.start = 0;
                this.end = MySpliteratorText.this.data.length - 1;
            }

            public MySpliterator(int start, int end) {
                this.start = start;
                this.end = end;
            }

            /**
             * 不管串行还是并行都会执行，有数据就进行Consumer,没有就返回false；
             *
             * @param action
             * @return
             */
            @Override
            public boolean tryAdvance(Consumer<? super String> action) {
                //元素是有的,就进行消费
                if (start <= end) {
                    action.accept(MySpliteratorText.this.data[start++]);
                    return true;
                }
                return false;
            }

            @Override
            public Spliterator<String> trySplit() {
                int mid = (end - start) / 2;
                //没有可拆的
                if (mid <= 1) {
                    return null;
                }

                int left = start;
                int right = start + mid;
                start = start + mid + 1;
                return new MySpliterator(left, right);
            }

            @Override
            public long estimateSize() {
                return end - start;
            }

            @Override
            public long getExactSizeIfKnown() {
                return estimateSize();
            }

            @Override
            public int characteristics() {
                return IMMUTABLE | SIZED | SUBSIZED;
            }
        }
    }
}
