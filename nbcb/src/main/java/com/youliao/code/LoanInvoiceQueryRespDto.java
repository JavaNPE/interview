package com.youliao.code;

import lombok.Builder;
import lombok.Data;

/**
 * @Author Dali
 * @Date 2021/10/28 14:47
 * @Version 1.0
 * @Description
 */
@Data
@Builder
public class LoanInvoiceQueryRespDto {
    private String isLoanAssistance;
    private String fundOrgName;
    private String trustPlanName;

}
