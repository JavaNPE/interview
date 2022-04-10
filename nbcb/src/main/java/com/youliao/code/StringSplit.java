package com.youliao.code;

import javafx.util.Pair;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author Dali
 * @Date 2021/12/15 10:38
 * @Version 1.0
 * @Description 19.【推荐】使用索引访问用 String 的 split 方法得到的数组时，需做最后一个分隔符后有无内容
 * 的检查，否则会有抛 IndexOutOfBoundsException 的风险。
 * 说明：
 * String str = "a,b,c,,";
 * String[] ary = str.split(",");
 * // 预期大于 3，结果是 3
 * System.out.println(ary.length);
 */
public class StringSplit {
	/**
	 * 19.【推荐】使用索引访问用 String 的 split 方法得到的数组时，需做最后一个分隔符后有无内容
	 * 的检查，否则会有抛 IndexOutOfBoundsException 的风险。
	 * 说明：
	 * String str = "a,b,c,,";
	 * String[] ary = str.split(",");
	 * // 预期大于 3，结果是 3
	 * System.out.println(ary.length);
	 */
	@Test
	public void testSplit() {
		String str = "a,b,c,,";

		String[] splitArr = str.split(",");
		System.out.println(splitArr.length);
	}

	/**
	 * 【强制】在使用 java.util.stream.Collectors 类的 toMap()方法转为 Map 集合时，一定要使
	 * 用含有参数类型为 BinaryOperator，参数名为 mergeFunction 的方法，否则当出现相同 key
	 * 值时会抛出 IllegalStateException 异常。
	 * 说明：参数 mergeFunction 的作用是当出现 key 重复时，自定义对 value 的处理策略。
	 * 正例：
	 */
	@Test
	public void toMapTest() {
		List<Pair<String, Double>> pairArrayList = new ArrayList<>(3);
		pairArrayList.add(new Pair<>("version1", 12.10));
		pairArrayList.add(new Pair<>("version2", 12.19));
		pairArrayList.add(new Pair<>("version3", 6.28));
		Map<String, Double> map = pairArrayList.stream().collect(
				// 生成的 map 集合中只有一个键值对：{version=6.28}
				Collectors.toMap(Pair::getKey, Pair::getValue, (v1, v2) -> v2));

		// 遍历Map集合
		Set<Map.Entry<String, Double>> entrySet = map.entrySet();
		for (Map.Entry<String, Double> entry : entrySet) {
			String key = entry.getKey();
			System.out.println("key:" + key + "---" + "value:" + entry.getValue());
		}
	}

	@Test
	public void toMapTest02() {
		String[] departments = new String[]{"iERP", "iERP", "EIBU"};
		// 抛出 IllegalStateException 异常
		Map<Integer, String> map = Arrays.stream(departments)
				.collect(Collectors.toMap(String::hashCode, str -> str));
	}

	/**
	 * 9. 【强制】使用集合转数组的方法，必须使用集合的 toArray(T[] array)，传入的是类型完全一
	 * 致、长度为 0 的空数组。
	 * 反例：直接使用 toArray 无参方法存在问题，此方法返回值只能是 Object[]类，若强转其它类型数组将出现
	 * ClassCastException 错误。
	 * <p>
	 * 说明：使用 toArray 带参方法，数组空间大小的 length：
	 * 1） 等于 0，动态创建与 size 相同的数组，性能最好。
	 * 2） 大于 0 但小于 size，重新创建大小等于 size 的数组，增加 GC 负担。
	 * 3） 等于 size，在高并发情况下，数组创建完成之后，size 正在变大的情况下，负面影响与 2 相同。
	 * 4） 大于 size，空间浪费，且在 size 处插入 null 值，存在 NPE 隐患。
	 */
	@Test
	public void listToArray() {
		List<String> list = new ArrayList<>(2);
		list.add("guan");
		list.add("bao");
		System.out.println(list);
		String[] array = list.toArray(new String[0]);
		for (String s : array) {
			System.out.print(s);
		}
	}

	/**
	 * 11.【强制】使用工具类 Arrays.asList()把数组转换成集合时，不能使用其修改集合相关的方法，
	 * 它的 add/remove/clear 方法会抛出 UnsupportedOperationException 异常。
	 * 说明：asList 的返回对象是一个 Arrays 内部类，并没有实现集合的修改方法。Arrays.asList 体现的是适配
	 * 器模式，只是转换接口，后台的数据仍是数组。
	 * String[] str = new String[] { "chen", "yang", "hao" };
	 * List list = Arrays.asList(str);
	 * 第一种情况：list.add("yangguanbao"); 运行时异常。
	 * 第二种情况：str[0] = "change"; 也会随之修改，反之亦然。
	 */
	@Test
	public void arrayToList() {
		String[] str = new String[]{"chen", "yang", "hao"};
		str[0] = "change";
		// 将数组转成集合
		List list = Arrays.asList(str);
		// list.add("yangguanbao");    // java.lang.UnsupportedOperationException

		System.out.println(list);
	}


	/**
	 * 14.【强制】不要在 foreach 循环里进行元素的 remove/add 操作。remove 元素请使用 Iterator
	 * 方式，如果并发操作，需要对 Iterator 对象加锁。
	 */
	@Test
	public void forAddAndRemove() {
		List<String> list = new ArrayList<>();
		list.add("2");
		list.add("2");
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			String item = iterator.next();
			if ("2".equals(item)) {
				iterator.remove();
			}
		}
		System.out.println(list);


		/*for (String item : list) {
			if ("2".equals(item)) {
				list.remove(item);
			}
		}
		System.out.println(list);*/
	}
}
