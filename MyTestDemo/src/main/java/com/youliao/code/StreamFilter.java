package com.youliao.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @Author Dali
 * @Date 2021/11/4 13:54
 * @Version 1.0
 * @Description: stream.filter一般适用于list集合, 主要作用就是模拟sql查询，从集合中查询想要的数据。filter里面的参数user是指集合里面的每一项
 */
public class StreamFilter {
    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        //定义三个用户对象
        User user1 = new User();
        user1.setUserName("王冉昕");
        user1.setPassWord("1234");
        System.out.println("user1:" + user1);

        User user2 = new User();
        user2.setUserName("王大力");
        user2.setPassWord("123456");
        System.out.println("user2:" + user2);

        User user3 = new User();
        user3.setUserName("王冉昕");
        user3.setPassWord("123456");
        System.out.println("user3:" + user3);

        //添加用户到集合中
        list.add(user1);
        list.add(user2);
        list.add(user3);

        System.out.println("list:" + list.toString());

        //在集合中查询用户名为huxiansen的集合
        List<User> userList = list.stream().filter(user -> "王冉昕".equals(user.getUserName())).collect(Collectors.toList());
        System.out.println(userList);

        //在集合中查询出第一个用户密码为123456的用户
        Optional<User> user = list.stream().filter(userTemp -> "123456".equals(userTemp.getPassWord())).findFirst();
        System.out.println(user);

        Map<String, User> collect = list.stream().filter(u -> u.getUserName().endsWith("昕")).collect(Collectors.toMap(User::getUserName, Function.identity(), (o1, o2) -> o2));
        System.out.println("collect:" + collect);
    }
}
