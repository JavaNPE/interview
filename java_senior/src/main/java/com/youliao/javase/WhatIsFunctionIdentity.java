package com.youliao.javase;

import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author Dali
 * @Date 2021/10/20 20:22
 * @Version 1.0
 * @Description： Function.identity()是什么？
 * <p>
 * Function是一个接口，那么Function.identity()是什么意思呢？解释如下：
 * <p>
 * Java 8允许在接口中加入具体方法。接口中的具体方法有两种，default方法和static方法，
 * identity()就是Function接口的一个静态方法。
 * <p>
 * Function.identity()返回一个输出跟输入一样的Lambda表达式对象，等价于形如t -> t形式的Lambda表达式。
 * <p>
 * 参考博客地址：https://www.jianshu.com/p/cd694d2d8be5
 */
public class WhatIsFunctionIdentity {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("I", "love", "you", "too");
        Map<String, Integer> streamMap = stream.collect(Collectors.toMap(Function.identity(), String::length));
        Set<Map.Entry<String, Integer>> entries = streamMap.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> next = iterator.next();
            String key = next.getKey();
            Integer value = next.getValue();
            System.out.println("key:" + key + "====>" + "value: " + value);
        }
        System.out.println(streamMap);
    }

    /**
     * 什么要使用Function.identity()代替str->str呢？它们有什么区别呢？
     * 在下面的代码中str -> str和Function.identity()是没什么区别的因为它们都是t->t
     */
    @Test
    public void test01() {
        Map<String, String> collectMap = Arrays.asList("a1", "b", "c").stream()
                .map(Function.identity())
                .map(str -> str)
                .collect(Collectors.toMap(Function.identity(), str -> str));
        System.out.println(collectMap);
    }

    /**
     * 但是我们有时候不能使用Function.identity，看下面的例子：
     */
    @Test
    public void test02() {
        List list = new ArrayList<>();
        list.add(1);
        list.add(2);
        System.out.println(list);

        int[] arrayOk = list.stream().mapToInt(i -> (int) i).toArray();
        System.out.println(arrayOk.toString());

        /**
         * 运行的时候就会错误，因为mapToInt要求的参数是ToIntFunction类型，但是ToIntFunction类型和Function没有关系
         */
       // int[] arrayNotOk = list.stream().mapToInt(Function.identity()).toArray();
    }
}
