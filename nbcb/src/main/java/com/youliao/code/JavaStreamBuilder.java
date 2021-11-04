package com.youliao.code;

import java.util.stream.Stream;

/**
 * @Author Dali
 * @Date 2021/11/4 11:09
 * @Version 1.0
 * @Description: Java Stream.Builder中的build()方法
 * 参考博客地址： https://www.nhooo.com/note/qa0s9c.html
 */
public class JavaStreamBuilder {
    public static void main(String[] args) {
        Stream.Builder<String> builder = Stream.builder();
        builder.add("One");
        builder.add("Two");
        builder.add("Three");
        builder.add("Four");
        builder.add("Five");
        builder.add("Six");
        builder.add("Seven");
        builder.add("Eight");
        System.out.println(builder);
        Stream<String> str = builder.build();
        str.forEach(System.out::println);
    }
}
