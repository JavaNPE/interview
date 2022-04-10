package com.youliao.code;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author Dali
 * @Date 2021/12/1 14:51
 * @Version 1.0
 * @Description
 */
public class StringToListString {
    @Test
    public void test1() {
        String productId = "NBCBZJD001,NBCBZJFEN001,NBCBZJFU001";
        List<String> productIdList = new ArrayList<>();
        Collections.addAll(productIdList,productId.split(","));
        System.out.println(productIdList);
    }
}
