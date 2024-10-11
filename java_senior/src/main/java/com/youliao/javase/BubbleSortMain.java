package com.youliao.javase;

import java.util.Arrays;

/**
 * @Author Dali
 * @Date 2021/9/14 17:07
 * @Version 1.0
 * @Description: 冒泡排序
 */
public class BubbleSortMain {
    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 65, 12, 34, 9};
        bubbleSort1(arr);
        String s = Arrays.toString(arr);
        System.out.println(s);
    }

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void bubbleSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        /**
         * arr.length = 6
         * i = 0
         * j = 0
         */
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (flag) {
                break;
            }
        }
    }
}
