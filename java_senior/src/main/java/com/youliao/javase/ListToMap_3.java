package com.youliao.javase;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Author Dali
 * @Date 2021/10/18 21:59
 * @Version 1.0
 * @Description： 将List转成Map的方法测试案例（重要)
 */
public class ListToMap_3 {
    public static void main(String[] args) {
        ArrayList<User> userList = new ArrayList<>();
        System.out.println("userList:" + userList);

        User user1 = new User();
        user1.setId(1L);
        user1.setAge("12");
        System.out.println("user1：" + user1);

        User user2 = new User();
        user2.setId(2L);
        user2.setAge("13");
        System.out.println("user2：" + user2);

        userList.add(user1);
        System.out.println("userList:" + userList);

        userList.add(user2);
        System.out.println("userList:" + userList);


        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put(1, "赫赫");
        hashMap.put(2, "昕昕");
        System.out.println("Map:" + hashMap);


        //方式一：使用传统的方式将List转成Map
    /*
        HashMap<Long, User> maps = new HashMap<>();
        for (User user : userList) {
            maps.put(user.getId(),user);
        }
        System.out.println(maps);
    */

        //方式二：使用JDK1.8昕特性的方式 Collectors.toMap()   将List转成Map
        Map<Long, User> collect = userList.stream().collect(Collectors.toMap(User::getId, Function.identity()));
        System.out.println(collect);

        Set<Map.Entry<Long, User>> entries = collect.entrySet();
        Iterator<Map.Entry<Long, User>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Long, User> userEntry = iterator.next();
            Long key = userEntry.getKey();
            User value = userEntry.getValue();
            System.out.println("key:" + key + "==" + "value:" + value);
        }
        System.out.println(entries);



        /**
         * 看来还是使用JDK 1.8方便一些。
         * 另外，转换成map的时候，可能出现key一样的情况，如果不指定一个覆盖规则，
         * 上面的代码是会报错的。转成map的时候，最好使用下面的方式：
         */
        Map<Long, User> collect1 = userList.stream().collect(Collectors.toMap(User::getId, Function.identity(), (key1, key2) -> key1));
        Map<Long, User> collect1_1 = userList.stream().collect(Collectors.toMap(User::getId, v->v, (key1, key2) -> key1));
        System.out.println("collect1" + collect1);
        System.out.println("collect1_1" + collect1);

        /**
         * 有时候，希望得到的map的值不是对象，而是对象的某个属性，那么可以用下面的方式：
         */
        Map<Long, String> collect2 = userList.stream().collect(Collectors.toMap(User::getId, User::getAge, (key1, key2) -> key2));
        System.out.println("collect2" + collect2);

    }

    public static class User {
        private Long id;
        private String age;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", age='" + age + '\'' +
                    '}';
        }
    }
}
