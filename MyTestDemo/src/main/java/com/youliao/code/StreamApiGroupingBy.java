package com.youliao.code;

import com.beust.jcommander.internal.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author Dali
 * @Date 2021/12/3 11:15
 * @Version 1.0
 * @Description
 */
public class StreamApiGroupingBy {
    /**
     * 例如，如果我们想按长度对字符串进行分组，
     * 我们可以通过将String :: length传递给groupingBy（）来实现：
     */
    @Test
    public void test01() {
        List<String> strings = Arrays.asList("a","bb","cc","ddd");
        System.out.println(strings);
    }

    @Test
    public void test02() {
//        String productIds = "CRCSZJD001,CRCSZJD002,CRCSZJD003";
//        List<String> productIdList = new ArrayList<>();
//        Collections.addAll(productIdList,productIds.split(","));
//        System.out.println(productIdList);


        List<String> list = Arrays.asList("CRCSZJD001,CRCSZJD002,CRCSZJD003");

    }
}
