package com.youliao.code;

/**
 * @Author Dali
 * @Date 2021/12/15 14:21
 * @Version 1.0
 * @Description
 */
public class SwitchStringTest {
	public static void main(String[] args) {
		method(null);
	}

	public static void method(String param) {
		switch (param) {
			// 肯定不是进入这里
			case "sth":
				System.out.println("it's sth");
				break;
			// 也不是进入这里
			case "null":
				System.out.println("it's null");
				break;
			// 也不是进入这里
			default:
				System.out.println("default");
		}
	}

}
