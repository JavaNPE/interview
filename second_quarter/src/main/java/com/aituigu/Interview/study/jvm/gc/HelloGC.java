package com.aituigu.Interview.study.jvm.gc;

/**
 * @Author Dali
 * @Date 2021/5/27 12:48
 * @Version 1.0
 * @Description: 60_ JVM的XX参数之布尔类型 https://www.bilibili.com/video/BV18b411M7xz?p=60&spm_id_from=pageDriver
 * <p>
 * https://www.bilibili.com/video/BV18b411M7xz?p=65&spm_id_from=pageDriver
 */
public class HelloGC {
    public static void main(String[] args) throws Exception {
        System.out.println("**********HelloGC");
        //Thread.sleep(Integer.MAX_VALUE);

     /*   // 返回Java虚拟机中内存的总量
        long totalMemory = Runtime.getRuntime().totalMemory();

        // 返回Java虚拟机中试图使用的最大内存量
        long maxMemory = Runtime.getRuntime().maxMemory();

        System.out.println("TOTAL_MEMORY(-Xms) = " + totalMemory + "(字节)、" + (totalMemory / (double) 1024 / 1024) + "MB");
        System.out.println("MAX_MEMORY(-Xmx) = " + maxMemory + "(字节)、" + (maxMemory / (double) 1024 / 1024) + "MB");*/

        /**
         * -Xms 设置初始分配大小，默认为物理内存的1/64
         * -Xmx 最大分配内存，默认为物理内存的1/4
         * -XX:+PrintGCDetails 输出详细的GC处理日志
         * 注意：参数调优一定要初始大小和最大分配内存的大小要一致
         */
        // VM参数： -Xms1024m -Xmx1024m -XX:+PrintGCDetails
        long maxMemory = Runtime.getRuntime().maxMemory();//返回 Java 虚拟机试图使用的最大内存量。
        long totalMemory = Runtime.getRuntime().totalMemory();//返回 Java 虚拟机中的内存总量。
        System.out.println("MAX_MEMORY = " + maxMemory + "（字节）、" + (maxMemory / (double) 1024 / 1024) + "MB");
        System.out.println("TOTAL_MEMORY = " + totalMemory + "（字节）、" + (totalMemory / (double) 1024 / 1024) + "MB");

    }
}
