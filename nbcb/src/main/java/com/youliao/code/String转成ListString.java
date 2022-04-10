package com.youliao.code;

import com.beust.jcommander.internal.Lists;

import java.util.Collections;
import java.util.List;

/**
 * @Author Dali
 * @Date 2021/12/3 9:54
 * @Version 1.0
 * @Description
 */
public class String转成ListString {
    public static void main(String[] args) {
        String productid = "NBCBZJD001,NBCBZJD002,NBCBZJD003";
        List<String> productidList = Lists.newArrayList();
        //List<String> productidList = Lists.newArrayList(productid);
        //System.out.println(productidList);  //[NBCBZJD001,NBCBZJD002,NBCBZJD003]

        Collections.addAll(productidList, productid.split(","));
        System.out.println("productidList:" + productidList);//productidList:[NBCBZJD001, NBCBZJD002, NBCBZJD003]

    }
}
