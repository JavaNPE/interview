package interview4.javase;

import java.math.BigDecimal;

/**
 * @Author HedianTea
 * @email daki9981@qq.com
 * @Date 2024/7/24 20:02
 * @Description:
 */
public class BigDecimal_Demo {
    public static void main(String[] args) {
        // 采用的推荐2 valueOf 的方式定义BigDecimal类型
        BigDecimal num = BigDecimal.valueOf(1234567890123456789.87654);
        System.out.println(num);    // 以科学计数法的形式展示
        System.out.println(num.toString()); // 以科学计数法的形式展示
        // 不使用科学计数法，但是长度过长的话，会对其进行截取
        System.out.println(num.toPlainString());
        System.out.println("-----------------------");
        // 采用推荐1（推荐方式） String 字符串的形式进行构建 BigDecimal 类型 输出的时候不容易失真
        BigDecimal num2 = new BigDecimal("1234567890123456789.876541112");
        System.out.println(num2);
        System.out.println(num2.toString());
        System.out.println(num2.toPlainString());
    }
}
