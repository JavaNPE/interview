package interview4.javase;

import java.math.BigDecimal;

/**
 * 整型包装类对象 Integer 有哪些坑？
 *
 * @Author HedianTea
 * @email daki9981@qq.com
 * @Date 2024/7/23 20:27
 * @Description:
 */
public class Integer_BugDemo {
    public static void main(String[] args) {
        // 在Java8中 可以正常 new Integer(1204); 但是在 Java17以后的版本此处 new Integer(1204); 编译报错，
        // 17以后的版本可以使用 Integer.valueOf(1024); 符合新版规范要求
/*
        Integer i1 = new Integer(1204);
        Integer i2 = Integer.valueOf(1024);
*/
        /**
         * ==：比较基本数据类型的时候，比较的是值，引用数据类型比较的是地址（new的对象，==比较永远是false）
         * equals：属于Object类的方法，如果我们没有重写过equals方法，那么它就是 ==，但是字符串里面的equals被重写过了，比较的是值
         */
        // 因为 600 不在区间 [-128, 127] 之间，底层会进行 new Integer(),在堆中创建对象
        Integer a = Integer.valueOf(600);
        Integer b = Integer.valueOf(600);
        int c = 600;

        System.out.println(a == b); // false, 因 600 不在  [-128, 127] 底层 new对象，== 比较的a，b堆中的两个不同的地址， 故为：false
        System.out.println(a.equals(b));    // true equals 比较
        System.out.println(a == c); // true,自动拆箱装箱进行匹配 600等于600

        System.out.println("==================");

        // 99 在  [-128, 127] 区间以内，会通过 IntegerCache.cache 复用同一个对象，说明是同一个
        Integer x = Integer.valueOf(99);
        Integer y = Integer.valueOf(99);

        System.out.println(x == y);         // true
        System.out.println(x.equals(y));    // true

        BigDecimal bigDecimal = new BigDecimal("0.1");
    }
}
