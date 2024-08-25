package interview4.javase;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author HedianTea
 * @email daki9981@qq.com
 * @Date 2024/7/25 20:37
 * @Description:
 */
public class StreamDebugDemo {
    public static void main(String[] args) {
        List<Integer> list =
                Stream.of(1, 2, 3, 4, 5, 6).filter(f -> f > 3).map(m -> m * 2).collect(Collectors.toList());
    }
}
