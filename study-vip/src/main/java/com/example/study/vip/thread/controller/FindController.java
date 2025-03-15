package com.example.study.vip.thread.controller;

import com.example.study.vip.thread.CreateAsync07;
import com.example.study.vip.thread.annotation.MyLogAnnotaion;
import com.example.study.vip.thread.async.LogAync;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class FindController {
    @Autowired
    private CreateAsync07 createAsync07;

    @GetMapping("/f")
    public String say(){
        System.out.println("我是主线程,线程名:"+Thread.currentThread().getName());
        createAsync07.AsyncTestMethod();
        System.out.println("我是主线程,执行完成，线程名:"+Thread.currentThread().getName());
        return "say";
    }

    @GetMapping("/f2")
    public String say2(){
        System.out.println("我是主线程,线程名:"+Thread.currentThread().getName());
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                createAsync07.AsyncTestMethod();
            }
        });

        System.out.println("我是主线程,执行完成，线程名:"+Thread.currentThread().getName());
        return "say";
    }

    @GetMapping("/f3")
    public String say3() throws ExecutionException, InterruptedException {
        System.out.println("我是主线程,线程名:"+Thread.currentThread().getName());

        String str = createAsync07.AsyncTestMethod2();

        System.out.println("子线程执行完后返回结果："+str);

        System.out.println("我是主线程,执行完成，线程名:"+Thread.currentThread().getName());
        return "say";
    }

    /**
     * CompletableFuture直接get获取结果会阻塞线程
     * @return
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @GetMapping("/f4")
    public String say4() throws ExecutionException, InterruptedException {
        System.out.println("我是主线程,线程名:"+Thread.currentThread().getName());

        CompletableFuture<String> stringCompletableFuture = createAsync07.AsyncTestMethod3();

        System.out.println("子线程执行完后返回结果："+stringCompletableFuture.get());

        System.out.println("我是主线程,执行完成，线程名:"+Thread.currentThread().getName());
        return "say";
    }

    /**
     * CompletableFuture通过
     * @return
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @GetMapping("/f5")
    public CompletableFuture<String> say5() throws ExecutionException, InterruptedException {
        System.out.println("我是主线程,线程名:"+Thread.currentThread().getName());
        CompletableFuture<String> stringCompletableFuture = createAsync07.AsyncTestMethod3().thenApply(result -> "=====子线程执行完后返回结果：" + result);
        System.out.println("我是主线程,执行完成，线程名:"+Thread.currentThread().getName());
        return stringCompletableFuture;
    }


    /**
     * CompletableFuture通过
     * @return
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @MyLogAnnotaion(name="f6")
    @GetMapping("/f6")
    public String say6() throws ExecutionException, InterruptedException {
        System.out.println("我是主线程,线程名:"+Thread.currentThread().getName());
        createAsync07.AsyncTestMethod3().thenAccept(result -> System.out.println("=====子线程执行完后返回结果：" + result));
        System.out.println("我是主线程,执行完成，线程名:"+Thread.currentThread().getName());
        return "Hello";
    }



    @Autowired
    LogAync logAync;

    @MyLogAnnotaion(name="f7")
    @GetMapping("/f7")
    public String say7(String a, double b){
        System.out.println("我是主线程,线程名:" + Thread.currentThread().getName());
        createAsync07.AsyncTestMethod3().thenApplyAsync(result -> {
                    return "=====子线程执行完后返回结果：" + result;
        }).thenAccept(fr -> System.out.println("finaResult" + fr));
        System.out.println("我是主线程,执行完成，线程名:" + Thread.currentThread().getName());
//        double vv =1/0;
        return "Hello";
    }
}
