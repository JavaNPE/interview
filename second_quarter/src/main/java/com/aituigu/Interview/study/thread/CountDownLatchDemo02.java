package com.aituigu.Interview.study.thread;

import com.aituigu.Interview.enmus.CountryEnum;

import java.util.concurrent.CountDownLatch;

/**
 * @Author Dali
 * @Date 2021/9/8 16:01
 * @Version 1.0
 * @Description
 */
public class CountDownLatchDemo02 {
    public static void main(String[] args) throws Exception {
        sixCountry();
    }

    /**
     * 秦灭六国 一统华夏
     *
     * @throws InterruptedException
     */
    private static void sixCountry() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t" + "国,灭亡");
                countDownLatch.countDown();
            }, CountryEnum.forEach(i).getName()).start();
        }
        countDownLatch.await();
        System.out.println("秦统一");
    }
}
