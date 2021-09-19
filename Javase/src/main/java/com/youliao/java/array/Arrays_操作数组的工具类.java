package com.youliao.java.array;

import java.util.Arrays;

/**
 * @Author Dali
 * @Date 2021/9/19 18:34
 * @Version 1.0
 * @Description： java.util.Arrays:操作数组的工具类，里面定义了很多操作数组的方法
 */
public class Arrays_操作数组的工具类 {
        public static void main(String[] args) {
        //1.boolean equals(int[] a,int[] b): 判断两个数组是否相等
        int[] arr1 = new int[]{1, 2, 3, 4};
        int[] arr2 = new int[]{1, 22, 3, 4};
        boolean isEquals = Arrays.equals(arr1, arr2);
        System.out.println(isEquals);   //true

        //2.String toString(int[] a): 输出数组信息
        System.out.println(Arrays.toString(arr1));  //[1, 2, 3, 4]

        //3.void fill(int [] a,int val):将指定值填充到数组之中
        // a – 要填充的数组
        //val – 要存储在数组所有元素中的值
        Arrays.fill(arr1, 10);
        System.out.println(Arrays.toString(arr1));  //[10, 10, 10, 10]

        //4.void sort(int[] a):对数组进行排序(默认是升序)
        Arrays.sort(arr2);
        System.out.println(Arrays.toString(arr2));//[1, 3, 4, 22]

        //5. int binarySearch(int[] a,int key)
        int[] arr3 = new int[]{-98, -34, 2, 34, 54, 66, 79, 105, 210, 333};
        int index = Arrays.binarySearch(arr3, 210);
        if (index >= 0) {
            System.out.println("索引为：" + index);     //索引为：8
        } else {
            System.out.println("未找到");
        }

    }
}
