package com.youliao.java.array;

/*
 * ⑤ 数组元素的默认初始化值
 * 		> 数组元素是整型：0
 * 		> 数组元素是浮点型：0.0
 * 		> 数组元素是char型：0或'\u0000'，而非'0'
 * 		> 数组元素是boolean型：false
 *
 * 		> 数组元素是引用数据类型：null
 *
 *  ⑥ 数组的内存解析
 */
public class ArrayTest1 {
    public static void main(String[] args) {
        //5.数组元素的默认初始化值
        System.out.print("int[]类型数组的初始化值：");
        int[] arr = new int[1];
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.print("short[]类型数组的初始化值：");
        short[] arr1 = new short[1];
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i]);
        }
        System.out.print("float[]类型数组的初始化值：");
        float[] arr2 = new float[1];
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]);
        }

        System.out.print("char[]类型数组的初始化值：");
        char[] arr3 = new char[1];
        for (int i = 0; i < arr3.length; i++) {
            System.out.print(arr3[i]);
        }
        if(arr3[0] == 0){   //数组元素是char型：0或'\u0000'，而非'0'
            System.out.println("你好！");
        }

        System.out.print("boolean[]类型数组的初始化值：");
        boolean[] arr4 = new boolean[1];
        for (int i = 0; i < arr4.length; i++) {
            System.out.println(arr4[i]);
        }

        System.out.print("String[]类型数组的初始化值：");
        String[] arr5 = new String[1];
        for (int i = 0; i < arr5.length; i++) {
            System.out.println(arr5[i]);
        }
    }
}
