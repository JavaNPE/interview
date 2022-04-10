package com.youliao.asynchronous;


import io.lettuce.core.internal.Futures;

import java.util.concurrent.*;
import java.util.function.Supplier;

/**
 * @Author Dali
 * @Date 2021/11/1 17:31
 * @Version 1.0
 * @Description： java异步编程
 * 参考博客：https://blog.csdn.net/tangyongzhe/article/details/49851769
 */
public class JavaPromise {

    public static void main(String[] args) throws Throwable, ExecutionException {
        // 两个线程的线程池
        ExecutorService executor = Executors.newFixedThreadPool(2);
        //jdk1.8之前的实现方式
        CompletableFuture<String> future = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                System.out.println("task started!");
                try {
                    //模拟耗时操作
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "task finished!";
            }
        }, executor);

        //采用lambada的实现方式
        future.thenAccept(e -> System.out.println(e + " ok"));

        System.out.println("main thread is running");
    }
}