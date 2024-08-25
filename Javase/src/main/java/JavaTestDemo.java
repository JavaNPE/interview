import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 测试类
 *
 * @Author HedianTea
 * @email daki9981@qq.com
 * @Date 2024/8/25 16:59
 * @Description:
 */
public class JavaTestDemo {

    @Test
    public void testAtomicInteger() {
        AtomicInteger atomicInteger = new AtomicInteger();
        System.out.println("默认值：" + atomicInteger); // 默认值：0
        int i = atomicInteger.incrementAndGet();
        System.out.println("i 的值是多少：" + i); // i 的值为：1

    }
}
