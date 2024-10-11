package com.youliao.code;

import com.beust.jcommander.internal.Lists;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author Dali
 * @Date 2021/10/27 14:37
 * @Version 1.0
 * @Description
 */
public class Test01 {
    public static void main(String[] args) {
        HashMap<String, NbcbProduct> nbcbMap = new HashMap<>();
        nbcbMap.put("1", new NbcbProduct(001, "丁一", "id_001"));
        nbcbMap.put("2", new NbcbProduct(002, "赫二", "id_002"));
        nbcbMap.put("3", new NbcbProduct(003, "张三", "id_003"));
        System.out.println("nbcbMap:" + nbcbMap);
        int size = nbcbMap.size();
        System.out.println(size);

        /*      方式一
        Stream<Integer> stream = nbcbMap.values().stream().map(NbcbProduct::getLoanInvoiceId);
        System.out.println("stream: " + stream);

        List<Integer> collect = stream.collect(Collectors.toList());
        System.out.println(collect);
        */
        //方式二：获取
        List<Integer> collect = nbcbMap.values().stream().map(NbcbProduct::getLoanInvoiceId).collect(Collectors.toList());
        System.out.println("coloct:" + collect);



    }

    @Test
    public void test01() {
        List<LoanInvoiceQueryRespDto> objectList = Lists.newArrayList();
        LoanInvoiceQueryRespDto loanInvoiceQueryRespDto = new LoanInvoiceQueryRespDto("1", "联合国", "阿波罗");
        objectList.add(loanInvoiceQueryRespDto);

        HashMap<String, NbcbProduct2> nbcbMap = new HashMap<>();
        nbcbMap.put("1", new NbcbProduct2("1", "丁一", "id_001"));
        nbcbMap.put("2", new NbcbProduct2("0", "赫二", "id_002"));
        nbcbMap.put("3", new NbcbProduct2("1", "张三", "id_003"));
        System.out.println("nbcbMap:" + nbcbMap);
        objectList.forEach(input -> {
            NbcbProduct2 nbcbProduct = nbcbMap.get("1");
            if (nbcbProduct != null) {
                input.setIsLoanAssistance(nbcbProduct.getIsLoanAssistance());
                input.setFundOrgName(nbcbProduct.getFundOrgName());
                input.setTrustPlanName(nbcbProduct.getTrustPlanName());
                System.out.println(input);
            }
        });
        System.out.println(objectList);
    }

    @Test
    public void testRandom() {
        /*int i = new Random().nextInt(1000);
        System.out.println(i);*/

        List<Integer> list = Arrays.asList(1,0,9,2);
        List<Integer> collect = list.stream().sorted(Comparator.comparing(Integer::byteValue))
                        .collect(Collectors.toList());
        System.out.println(collect);

        String str = null;
        BigDecimal bigDecimal = new BigDecimal(" ");
    }

    @Test
    public void test001() {
        LoanService loanService = new LoanService();
        Customer customer = new Customer("12345");

        // 第一次借款（首次借款）
        loanService.handleLoan(customer, false);  // 配置未变更时，插入 A1=1.5%

        // 第二次借款（非首次借款）
        loanService.handleLoan(customer, false);  // 配置未变更时，插入 B1=1.0%

        // 第三次借款（配置变更后，非首次借款依然使用变更前B1=1.0%）
        loanService.handleLoan(customer, true);  // 配置变更后，插入依然是 B1=1.0%

        // 第四次借款（新配置生效，首次借款使用A2=1.0%）
        loanService.handleLoan(customer, true);  // 配置变更后，插入 B2=0.8%（但是不会影响之前的 B1）
    }




}
