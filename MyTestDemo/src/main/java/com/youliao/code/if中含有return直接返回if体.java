package com.youliao.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author Dali
 * @Date 2021/12/3 9:24
 * @Version 1.0
 * @Description
 */
public class if中含有return直接返回if体 {
    public static void main(String[] args) {
        String pId = "CRCSZJD001,CRCSZJD002,CRCSZJD003";
        List<String> productIdList = new ArrayList<>();
        Collections.addAll(productIdList, pId.split(","));
//        productIdList.add(pId);
        System.out.println("pId:" + pId);
        System.out.println("productIdList:" + productIdList);

        //List<String> productIdList = Collections.singletonList("CRCSZJD001,CRCSZJD002,CRCSZJD003");

        if (productIdList.contains("CRCSZJD001")) {
            System.out.println("111111111111");
            return;
        }
        System.out.println("22222222222");
    }
}
