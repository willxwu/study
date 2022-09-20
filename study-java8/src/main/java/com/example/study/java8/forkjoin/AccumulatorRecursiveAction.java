package com.example.study.java8.forkjoin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.concurrent.RecursiveAction;
import java.util.concurrent.atomic.AtomicInteger;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AccumulatorRecursiveAction extends RecursiveAction {
    private int start;
    private int end;
    private int[] data;
    private int LIMIT = 3;

    public AccumulatorRecursiveAction(int start, int end, int[] data) {
        this.start = start;
        this.end = end;
        this.data = data;
    }

    @Override
    protected void compute() {
        //如果小于3个就可以直接进行计算了，否则fork成多个，再计算
        if (end - start < LIMIT) {
            for (int i = start; i < end; i++) {
                AccumulatorHelper.accumulate(data[i]);
            }
        } else {
            int mid = (start + end) / 2;
            AccumulatorRecursiveAction left = new AccumulatorRecursiveAction(start, mid, data);
            AccumulatorRecursiveAction right = new AccumulatorRecursiveAction(mid, end, data);
            right.fork();
            left.fork();
            right.join();
            left.join();
        }
    }

    static class AccumulatorHelper {
        private static final AtomicInteger result = new AtomicInteger(0);

        static void accumulate(int value) {
            result.getAndAdd(value);
        }

        public static int getResult() {
            return result.get();
        }

        static void rest() {
            result.set(0);
        }
    }
}
