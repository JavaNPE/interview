package com.youliao.javase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Author Dali
 * @Date 2021/10/18 21:59
 * @Version 1.0
 * @Description
 */
public class ListToMap_3 {
    public static void main(String[] args) {
        ArrayList<User> userList = new ArrayList<>();
        User user1 = new User();
        user1.setId(1L);
        user1.setAge("12");

        User user2 = new User();
        user2.setId(2L);
        user2.setAge("13");
        userList.add(user1);
        userList.add(user2);


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

        //方式二：使用JDK1.8昕特性的方式 Collectors.toMap()
        Map<Long, User> collect = userList.stream().collect(Collectors.toMap(User::getId, Function.identity()));
        System.out.println(collect);

        /**
         * 看来还是使用JDK 1.8方便一些。
         * 另外，转换成map的时候，可能出现key一样的情况，如果不指定一个覆盖规则，
         * 上面的代码是会报错的。转成map的时候，最好使用下面的方式：
         */
        Map<Long, User> collect1 = userList.stream().collect(Collectors.toMap(User::getId, Function.identity(), (key1, key2) -> key1));
        System.out.println(collect1);

        /**
         * 有时候，希望得到的map的值不是对象，而是对象的某个属性，那么可以用下面的方式：
         */
        Map<Long, String> collect2 = userList.stream().collect(Collectors.toMap(User::getId, User::getAge, (key1, key2) -> key2));
        System.out.println(collect2);

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
