package com.aituigu.Interview.study.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Author Dali
 * @Date 2021/5/23 19:02
 * @Version 1.0
 * @Description: 阻塞队列
 * 1、队列
 * 2、阻塞队列
 * 2.1 阻塞队列有没有好的一面
 * 2.2 不得不阻塞，如何管理
 */
public class BlockingQueueDemo {
    public static void main(String[] args) {
        //List list = new ArrayList();  //ArrayList初始容量为10
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(3);    //设置初始容量

        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
        System.out.println(blockingQueue.element());    // 检查队列空不空，检查首元素是谁
        System.out.println("-----------------------");
        System.out.println(blockingQueue.remove());     //队列先进先出
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());     //Exception in thread "main" java.util.NoSuchElementException

    }
}
