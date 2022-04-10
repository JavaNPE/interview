package com.youliao.code;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author Dali
 * @Date 2021/12/2 14:16
 * @Version 1.0
 * @Description
 */
public class List集合往里面分批塞不同的值 {
    @Test
    public void test01() {
        List<String> rangRuleIdList = new ArrayList<>();
        String loanAmountRangId = "NBCB001,NBCB002,NBCB003";
        rangRuleIdList.add(loanAmountRangId);
        //Collections.addAll(rangRuleIdList,loanAmountRangId);
        String preRepayAmountRangeId = "wrx969,wrx979,wrx989";
        rangRuleIdList.add(preRepayAmountRangeId);
        String preRepayInterestRangeId = "1000001,100002,100003";
        rangRuleIdList.add(preRepayInterestRangeId);
        System.out.println(rangRuleIdList);
    }

    /**
     * 演示if里面添加break是否会执行外部的return语句
     * @return
     */
    @Test
    public int test02() {
//        String pid = "NBCBZJD001,NBCBZJD002,NBCBZJD003";
//        System.out.println(pid);
        List<String> productIdList = Collections.singletonList("NBCBZJD001,NBCBZJD002,NBCBZJD003");

        if (productIdList.contains("NBCBZJD003")) {
            return 9;
        }
//        System.out.println(productIdList);
        return 5;
    }
}
