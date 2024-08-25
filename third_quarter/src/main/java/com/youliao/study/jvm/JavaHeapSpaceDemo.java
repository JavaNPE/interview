package com.youliao.study.jvm;

/**
 * OutOfMemoryError
 * java heap space
 *
 * @Author HedianTea
 * @email daki9981@qq.com
 * @Date 2024/7/11 13:57
 * @Description:
 */
public class JavaHeapSpaceDemo {
    public static void main(String[] args) {

        // 堆空间的大小 -Xms10m -Xmx10m
        // 创建一个 80M的字节数组
        byte[] bytes = new byte[80 * 1024 * 1024];
    }
}
