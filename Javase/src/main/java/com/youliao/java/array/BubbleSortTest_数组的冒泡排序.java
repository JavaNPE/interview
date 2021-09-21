package com.youliao.java.array;

import java.util.concurrent.ForkJoinPool;

/**
 * @Author Dali
 * @Date 2021/9/21 17:34
 * @Version 1.0
 * @Description: 数组的冒泡排序的实现
 */
public class BubbleSortTest_数组的冒泡排序 {
    public static void main(String[] args) {
        int[] arr = new int[]{43, 32, 76, -98, 0, 64, 33, -21, 32, 99};

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }
}
