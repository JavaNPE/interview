package com.youliao.code;

/**
 * @Author HedianTea
 * @email daki9981@qq.com
 * @Date 2024/9/29 15:09
 * @Description:
 */
public class LoanService {
    // 模拟配置值
    private static final double A1 = 1.5;  // 初始首次借款利率
    private static final double A2 = 1.0;  // 配置变更后首次借款利率
    private static final double B1 = 1.0;  // 初始非首次借款利率
    private static final double B2 = 0.8;  // 配置变更后非首次借款利率

    // 模拟客户的贷款状态
    private boolean isFirstLoan = true; // 判断是否首次借款，初始设定为首次借款
    private double previousNonFirstLoanRate = B1; // 保存非首次借款的配置值

    // 主逻辑：处理贷款
    public void handleLoan(Customer customer, boolean configChanged) {
        double rateToInsert;
        double rateToSend;

        if (isFirstLoan) {
            // 首次借款处理
            rateToInsert = configChanged ? A2 : A1;
            rateToSend = rateToInsert;

            // 插入首次借款利率到数据库
            insertOrUpdateRateInDatabase(customer, rateToInsert);

            // 给核算系统传递首次借款利率
            sendRateToAccountingSystem(customer, rateToSend);

            // 首次借款后，设置为非首次借款
            isFirstLoan = false;
        } else {
            // 非首次借款处理
            rateToInsert = previousNonFirstLoanRate;  // 插入数据库的值依然是变更前的非首次借款利率B1
            rateToSend = previousNonFirstLoanRate;    // 给核算系统传递变更前的非首次借款利率B1

            // 插入非首次借款利率到数据库
            insertOrUpdateRateInDatabase(customer, rateToInsert);

            // 给核算系统传递非首次借款利率
            sendRateToAccountingSystem(customer, rateToSend);

            // 如果配置变更，保存变更前的非首次借款利率
            if (configChanged) {
                previousNonFirstLoanRate = B2; // 更新非首次借款配置为B2
            }
        }
    }

    // 插入或更新 rate 字段到数据库
    private void insertOrUpdateRateInDatabase(Customer customer, double rate) {
        // 伪代码：执行数据库操作
        System.out.println("Inserting or updating rate for customer: " + customer.getId() + " with rate: " + rate);
        // 实际操作：在credit_loan_invoice_project表中插入或更新rate字段
    }

    // 给核算系统传递利率
    private void sendRateToAccountingSystem(Customer customer, double rate) {
        // 伪代码：传递 rate 值到核算系统
        System.out.println("Sending rate to accounting system for customer: " + customer.getId() + " with rate: " + rate);
    }
}

// 模拟客户类
class Customer {
    private String id;

    public Customer(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
