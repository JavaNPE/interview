package com.youliao.code;

import com.beust.jcommander.internal.Lists;
import com.beust.jcommander.internal.Maps;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @Author Dali
 * @Date 2021/11/24 9:18
 * @Version 1.0
 * @Description
 */
public class ListsTransform {
    public static void main(String[] args) {

        Map<String,String> map = Maps.newHashMap();
        map.put("a","testa");
        map.put("b","test2");
        map.put("c","test3");
        Map<String,String> map2 = Maps.newHashMap();
        map2.put("a","test3");
        map2.put("b","testb");
        map2.put("d","testc");
        List<Map<String,String>> list2= Lists.newArrayList();
        list2.add(map);
        list2.add(map2);
//        List<String> list3=Lists.transform(list2, s->s.get("a"));
//        list3.forEach(s -> System.out.println(s));
    }
}
