package com.aituigu.Interview.enmus;

import lombok.Getter;

/**
 * @Author Dali
 * @Date 2021/9/8 15:59
 * @Version 1.0
 * @Description：枚举的使用
 */
public enum CountryEnum {
    /**
     *
     */
    ONE(1, "齐"),
    /**
     *
     */
    TWO(2, "楚"),
    /**
     *
     */
    THREE(3, "燕"),
    /**
     *
     */
    FOUR(4, "赵"),
    /**
     *
     */
    FIVE(5, "魏"),
    /**
     *
     */
    SIX(6, "韩");

    CountryEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    @Getter
    private Integer code;
    @Getter
    private String name;

    public static CountryEnum forEach(int index) {
        CountryEnum[] countryEnums = CountryEnum.values();
        for (CountryEnum countryEnum : countryEnums) {
            if (index == countryEnum.getCode()) {
                return countryEnum;
            }
        }
        return null;
    }
}
