package com.example.study.java8.forkjoin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.concurrent.RecursiveTask;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccumulatorRecursiveTask extends RecursiveTask<Integer> {
    private  int start;
    private  int end;
    private  int[] data;
    private  int LIMIT=3;

    public AccumulatorRecursiveTask(int start, int end, int[] data) {
        this.start = start;
        this.end = end;
        this.data = data;
    }

    @Override
    protected Integer compute() {
        //如果小于3个就可以直接进行计算了，否则fork成多个，再计算
        if(end -start <LIMIT) {
            int result =0;
            for(int i=start;i<end;i++){
                result+=data[i];
            }
            return result;
        }

        int mid = (start+end)/2;
        AccumulatorRecursiveTask left = new AccumulatorRecursiveTask(start,mid,data);
        AccumulatorRecursiveTask right = new AccumulatorRecursiveTask(mid,end,data);

        left.fork();
        Integer rightResult = right.compute();
        Integer leftResult = left.join();
        return rightResult+leftResult;
    }
}
