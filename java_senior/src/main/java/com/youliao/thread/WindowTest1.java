package com.youliao.thread;

/**
 * @Author Dali
 * @Date 2021/07/22 上午 6:41
 * @Version 1.0
 * @Description
 */
class Window1 implements Runnable {
    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket);
                ticket--;
            } else {
                break;
            }
        }
    }
}

public class WindowTest1 {
    public static void main(String[] args) {
        Window1 w = new Window1();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);
/*        Window1 t1 = new Window1();
        Window1 t2 = new Window1();
        Window1 t3 = new Window1();*/


        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();

    }
}
