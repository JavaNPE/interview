package com.aituigu.Interview.study.thread;

import sun.plugin2.gluegen.runtime.CPU;

/**
 * 通过代码查看CPU核心数
 * @Author HedianTea
 * @email daki9981@qq.com
 * @Date 2024/8/27 10:54
 * @Description:
 */
public class GetCPUParameter {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors()); //CPU
    }
}
