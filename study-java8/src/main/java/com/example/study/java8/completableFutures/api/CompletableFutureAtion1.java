package com.example.study.java8.completableFutures.api;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

/**
 * CompletableFuture常用API: thenApply、handle
 */
public class CompletableFutureAtion1 {

    public static void main(String[] args) throws InterruptedException {

/*        //API-- 1、thenApply
        //模拟其它 异步 逻辑操作然后返回结果1
        CompletableFuture.supplyAsync(() -> 1)
                .thenApply(i -> Integer.sum(i, 10))  //thenApply      将结果加10
                .whenComplete((v, t) -> Optional.ofNullable(v).ifPresent(System.out::println));   //同步执行打印结果
//              .whenCompleteAsync() //异步操作，可以将结果在进行其它逻辑异步操作

//whenComplete  VS whenCompleteAsync*/




/*        //API- 2、handle
        CompletableFuture.supplyAsync(() -> 1)
                .handle((v, t) -> Integer.sum(v, 10))
                .whenComplete((v, t) -> Optional.ofNullable(v).ifPresent(System.out::println));


//       thenApply VS handle :handle只是多了一个对堆内存的考虑。*/


/*
        //API-3、thenRun:所有结果执行完后，执行其它操作
        CompletableFuture.supplyAsync(() -> 1)
                .handle((v, t) -> Integer.sum(v, 10))
                .whenComplete((v, t) -> Optional.ofNullable(v).ifPresent(System.out::println))
                .thenRun(System.out::println);  //这里没有入参，只会打印一个换行
//              .thenRunAsync()  如果做成异步的就用这个方法
*/


/*        //API-4、thenAccept:不会有任何返回值,只是对结果进行消费
        CompletableFuture.supplyAsync(() -> 1)
                .thenAccept(System.out::println);*/

/*

        //API-5、thenCompose:将异步产生的结果，再交(组合)给另一个ComletableFuture进行处理，是有返回值的。
        CompletableFuture.supplyAsync(() -> 1)
                .thenCompose(i -> CompletableFuture.supplyAsync(() -> 10 * i))   //将1再组合成另一个CompletableFuture处理
                .thenAccept(System.out::println); //然后消费，直接输出结果
*/



/*        //API-6、thenCombine:将异步产生的结果，与另一个CompletableFuture结果，作为参数进行处理,有返回值。
        CompletableFuture.supplyAsync(() -> 1)
                .thenCombine(CompletableFuture.supplyAsync(()->0.2),(v1,v2)->v1+v2)
                .thenAccept(System.out::println);*/

        //API-7、thenAcceptBoth:将异步产生的结果，与另一个CompletableFuture结果，作为参数进行处理，没有返回值，直接用于消费。
        CompletableFuture.supplyAsync(() -> 1)
                .thenAcceptBoth(CompletableFuture.supplyAsync(()->0.5), (v1,v2)->{
                    System.out.println(v1);
                    System.out.println(v2);
                });

//        thenCombine  VS thenAcceptBoth：2个方法类似，有个有返回值，有个没有返回值。




        //为了防止主线程结束后，守护线程被关闭，模拟修改10000毫秒
        Thread.sleep(10000);
    }
}
