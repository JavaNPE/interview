package interview4.javase;

import interview4.javase.entity.Person;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author HedianTea
 * @email daki9981@qq.com
 * @Date 2024/7/24 20:51
 * @Description:
 */
public class TestEquals {
    public static void main(String[] args) {

        // s1 和 s2 是引用类型 == 比较基本类型比较的是值，==比较引用类型 笔记的地址，此处会复写 hashcode 和 equals 方法
        String s1 = new String("abc");
        String s2 = new String("abc");
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));

        Set<String> set01 = new HashSet<>();
        set01.add(s1);
        set01.add(s2);
        System.out.println(set01.size());
        // hashCode 和 equals 被重写，哈希值一样，被认为同一个对象，set01.size() 为 1
        System.out.println(s1.hashCode() + "\t" + s2.hashCode());
        System.out.println("==================");

        // 注意：Person 类没有复写 hashCode 和 equals 方法，p1 和 p2 用的还是 Object 的equals方法
        Person p1 = new Person("abc");
        Person p2 = new Person("abc");
        System.out.println(p1 == p2);
        // equals：属于Object类的方法，如果我们没有重写过equals方法，那么它就是 Object 中默认的 ==
        System.out.println(p1.equals(p2));  // 两个对象指向不一样，为 false
        Set<Person> set02 = new HashSet<>();
        set02.add(p1);
        set02.add(p2);
        // 因 Person 类没有复写 hashCode 和 equals 方法，哈希值不一样，故 set02.size() 为 2
        System.out.println(set02.size());
        System.out.println(p1.hashCode() + "\t" + p2.hashCode());
        System.out.println("==================");
    }
}













