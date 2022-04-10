package com.youliao.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author Dali
 * @Date 2021/11/15 9:50
 * @Version 1.0
 * @Description
 */
public class CollectionsSort {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("beijing");
        list.add("shanghai");
        list.add("hangzhou");
        Collections.sort(list, new Comparator<String>() {


            @Override
            public int compare(String str1, String str2) {

                /**
                 　　　　　　* 升序排的话就是第一个参数.compareTo(第二个参数);
                 　　　　　　* 降序排的话就是第二个参数.compareTo(第一个参数);
                 　　　　　　*/

                // 按首字母升序排
                //return str1.compareTo(str2);  //[beijing, hangzhou, shanghai]
                return str2.compareTo(str1);    //[shanghai, hangzhou, beijing]
                // 按第二个字母升序排
//                char c1 = str1.charAt(1);
//                char c2 = str2.charAt(1);
//                return c1 - c2;
            }

        });
        System.out.println(list);
    }
}
