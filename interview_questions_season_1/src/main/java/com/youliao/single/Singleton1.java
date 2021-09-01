package com.youliao.single;

/**
 * @Author Dali
 * @Date 2021/7/30 16:35
 * @Version 1.0
 * @Description： 饿汉式：在类初始化时直接创建实例对象，不管你是否需要这个对象都会创建
 * 1、构造器（方法）私有化
 * 2、执行创建，并且用静态变量保存
 * 3、向外提供这个实例
 * 4、强调这是一个单例，我们可以用final修饰
 */
public class Singleton1 {
    public static final Singleton1 INSTANCE = new Singleton1();

    private Singleton1() {
    }
}
