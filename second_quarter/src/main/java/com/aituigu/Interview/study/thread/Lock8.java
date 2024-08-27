package com.aituigu.Interview.study.thread;

import java.util.concurrent.TimeUnit;

/**
 * 多线程8锁
 *  1.标准访问：请问先打印邮件还是短信？ //先打印邮件
 *  2.邮件方法暂停4秒钟 请问先打印邮件还是短信？ 先打印邮件
 *  3.新增一个普通方法hello()，请问先打印邮件还是hello？  先打印hello
 *  4.有两部手机，请问先打印邮件还是短信？  先打印短信
 *  5.两个静态同步方法，同一部手机，请问先打印邮件还是短信？  先打印邮件
 *  6.两个静态同步方法，两部手机，请问先打印邮件还是短信？ 先打印邮件
 *  7.一个普通同步方法,一个静态同步方法，一部手机，请问先打印邮件还是短信？   先打印短信
 * 8.一个普通同步方法,一个静态同步方法，两部手机，请问先打印邮件还是短信？  先打印短信
 */
class Phone8 {
    public static synchronized void sendEmail() throws Exception {
        // sleep
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("-----sendEmail");
    }

    public synchronized void sendSMS() throws Exception {
        System.out.println("-----sendSMS");
    }

    public void hello() {
        System.out.println("-----hello");
    }
}

public class Lock8 {

    public static void main(String[] args) throws Exception {
        Phone8 phone = new Phone8();
        Phone8 phone2 = new Phone8();
        new Thread(() -> {
            try {
                phone.sendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "A").start();

        Thread.sleep(100);

        new Thread(() -> {
            try {
                //phone.sendSMS();
                // phone.hello();
                phone2.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "B").start();
    }
}

