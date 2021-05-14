package jvm;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * @Author Dali
 * @Date 2021/5/14 15:42
 * @Version 1.0
 * @Description
 */

class MyData {
    int number = 0;

    public void addT060() {
        this.number = 60;
    }
}

/**
 * 1、验证volatile的可见性
 * 1.1 假如int number = 0;, number变量之前根本没有添加volatile关键字修饰 ,没有可见性
 */
public class VolatileDemo {
    public static void main(String[] args) {
        MyData myData = new MyData();       //资源类
        new Thread(() -> {      //线程1 AAA
            System.out.println(Thread.currentThread().getName() + "\t come in");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.addT060();
            System.out.println(Thread.currentThread().getName() + "\t update number value: " + myData.number);
        }, "AAA").start();

        //第2个线程就是我们的main线程
        while (myData.number == 0){
            // main线程就一一直再这里等待循环，直到number 值不再等于零。
        }
        System.out.println(Thread.currentThread().getName()+"\t 任务完成"); //如果打印的是60 则感知 myData已被修改
    }
}


