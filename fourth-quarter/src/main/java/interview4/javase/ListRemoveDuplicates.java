package interview4.javase;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 关于 List 去重问题：
 * 某大厂校招真实题目，List去重你能想到几种？要求至少写出3个，考察熟练度！
 *
 * @Author HedianTea
 * @email daki9981@qq.com
 * @Date 2024/7/24 20:23
 * @Description:
 */
public class ListRemoveDuplicates {
    public static void main(String[] args) {
        // m2();
        m3();
    }

    /**
     * 通过使用 Stream 流 distinct 进行直接去重
     */
    private static void m3() {
        List<Integer> initList = Arrays.asList(1, 2, 2, 5, 8, 8, 8, -10, -10, 3);
        List<Integer> srcList = new ArrayList<>(initList);
        List<Integer> newList = new ArrayList<>();
        // 保持顺序
        newList = srcList.stream().distinct().collect(Collectors.toList());
        newList.forEach(s -> System.out.print(s + " "));

    }

    /**
     * 使用 HashSet 去重！（HashSet 特性所致：有天然的去重优势）,HashSet 无序，不重复（去重后顺序会乱）
     */
    private static void m2() {
        List<Integer> srcList = Arrays.asList(1, 2, 2, 5, 8, 8, 8, -10, -10, 3);
        List<Integer> newList = new ArrayList<>(new HashSet<>(srcList));
        newList.forEach(s -> System.out.print(s + " "));

        System.out.println();

        newList = new ArrayList<>(new LinkedHashSet<>(srcList));
        newList.forEach(s -> System.out.print(s + " "));
    }
}
