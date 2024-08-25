package com.youliao.study.jvm;

/**
 * @Author HedianTea
 * @email daki9981@qq.com
 * @Date 2024/7/11 11:24
 * @Description:
 */
public class StackOverflowErrorDemo {
    public static void main(String[] args) {
        stackOverflowError();
    }
    /**
     * 栈一般是512K，不断的深度调用，直到栈被撑破
     * Exception in thread "main" java.lang.StackOverflowError
     */
    private static void stackOverflowError() {
        stackOverflowError();
    }
}
