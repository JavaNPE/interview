package com.aituigu.Interview.study.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author Dali
 * @Date 2021/9/9 13:04
 * @Version 1.0
 * @Description 请您说说synchronized和Lock的区别？用lock有什么好处？
 * synchronized是JVM层面，它是JAVA的关键字
 * synchronized 是不需要手动释放锁，当synchronized代码执行完以后，系统会自动让线程释放对锁的占用
 * synchronized不能中断，除非是抛出了异常或者是正常执行完成
 * synchronized是非公平锁
 * synchronized不支持精确唤醒，只能随机唤醒或者是唤醒全部线程
 * <p>
 * Lock是API层面的具体类，它是java5以后新出的一个类
 * lock就需要手动去释放锁，若没有主动的去释放锁，就可能导致死锁的现象
 * lock是可以中断的，主要是设置超时的方法，
 * lock默认是非公平锁，但是也支持公平锁
 * lock可支持精确唤醒
 * <p>
 * <p>
 * 多线程之间按顺序调用，实现A->B->C 三个线程启动
 * AA打印5次， BB打印10次，CC打印15次
 * 紧接着
 * AA打印5次， BB打印10次，CC打印15次
 * 来十轮
 **/
class ShareResource {
    private int number = 1;
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    //第一个线程
    public void print5() {
        lock.lock();
        try {
            //判断
            while (number != 1) {  //说明是首次线程进来
                c1.await(); //进来等着
            }
            //2.干活
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            //3.通知B线程
            number = 2;
            c2.signal();//通知b线程

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    //第二个线程
    public void print10() {
        lock.lock();
        try {
            //判断
            while (number != 2) {  //说明是首次线程进来
                c2.await(); //进来等着
            }
            //2.干活
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            //3.通知B线程
            number = 3;
            c3.signal();//通知b线程

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    //第3个线程
    public void print15() {
        lock.lock();
        try {
            //判断
            while (number != 3) {  //说明是首次线程进来
                c3.await(); //进来等着
            }
            //2.干活
            for (int i = 1; i <= 15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            //3.重新回去通知A线程
            number = 1;
            c1.signal();//通知A线程

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}

public class SyncAndReentrantLockDemo {
    public static void main(String[] args) {
        ShareResource shareResource = new ShareResource();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                shareResource.print5();
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                shareResource.print10();
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                shareResource.print15();
            }
        }, "C").start();
    }
}
