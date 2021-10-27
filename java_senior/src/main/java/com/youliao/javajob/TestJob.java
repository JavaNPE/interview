//package com.youliao.javajob;
//
//
//
//import java.util.Calendar;
//import java.util.Timer;
//import java.util.TimerTask;
//
//
///**
// * @Author Dali
// * @Date 2021/10/26 9:33
// * @Version 1.0
// * @Description ：java实现job功能，定时开启任务（在开发的过程中，有时候需要java实现job功能，定时开启或者每个一段时间重复一个任务。定时开启或者每个一段时间重复一个任务）
// * 参考博客：https://blog.csdn.net/Dante_003/article/details/41316261
// * <p>
// * TimerTask实现了Runnable()接口： 故须重写run()方法下
// */
//public class TestJob extends TimerTask {
//    public static void main(String[] args) {
//        Timer timer = new Timer();
//        Calendar date = Calendar.getInstance();
//        date.set(Calendar.HOUR_OF_DAY, 0);
//        date.set(Calendar.MINUTE, 0);
//        date.set(Calendar.SECOND, 0);
//        date.set(Calendar.MILLISECOND, 0);
//        timer.schedule(new TestJob(), date, 1000*60*60*24);
//    }
//    @Override
//    public void run() {
//        System.out.println("执行今天的job任务");
//    }
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
