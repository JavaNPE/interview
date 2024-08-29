package com.youliao.code;

import lombok.Builder;
import lombok.Data;

/**
 * @Author Dali
 * @Date 2021/10/27 14:34
 * @Version 1.0
 * @Description
 */
@Data
@Builder
public class NbcbProduct {
    private int loanInvoiceId;
    private String userName;
    private String productName;
}
