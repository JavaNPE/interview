package com.aituigu.Interview.study.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 生产者消费者  阻塞队列版
 *
 * @Author HedianTea
 * @email daki9981@qq.com
 * @Date 2024/8/25 18:27
 * @Description: valatile/cas/atomicInteger/BlockQueue//
 * 使用：volatile、CAS、atomicInteger、BlockQueue、线程交互、原子引用
 */
class MyResource {
    private volatile boolean FLAG = true; //+
    private AtomicInteger atomicInteger = new AtomicInteger();

    BlockingQueue<String> blockingQueue = null;

    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    //
    public void MyProd() throws Exception {
        String data = null;
        boolean retValue; //false

        while (FLAG) {
            //
            data = atomicInteger.incrementAndGet() + "";//++i
            retValue = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
            if (retValue) { //true
                System.out.println(Thread.currentThread().getName() + "\t" + data + "");
            } else {  //
                System.out.println(Thread.currentThread().getName() + "\t" + data + "");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        //FLAGfalse
        System.out.println(Thread.currentThread().getName() + "\tFLAG=false,");
    }

    //
    public void MyConsumer() throws Exception {
        String result = null;
        while (FLAG) { //
            //
            result = blockingQueue.poll(2L, TimeUnit.SECONDS);
            if (null == result || result.equalsIgnoreCase("")) { //
                FLAG = false;
                System.out.println(Thread.currentThread().getName() + "\t ");
                System.out.println();
                System.out.println();
                return;//
            }
            System.out.println(Thread.currentThread().getName() + "\t" + result + "");
        }
    }

    //
    public void stop() throws Exception {
        this.FLAG = false;
    }

}

public class ProdConsumer_BlockQueueDemo {
    public static void main(String[] args) throws Exception {
        MyResource myResource = new MyResource(new ArrayBlockingQueue<>(10));
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t ");
            try {
                myResource.MyProd();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "Prod").start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t ");
            System.out.println();
            System.out.println();
            try {
                myResource.MyConsumer();
                System.out.println();
                System.out.println();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "Consumer").start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("5bossMain");
        myResource.stop();
    }
}

