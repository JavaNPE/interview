package com.youliao.javase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author Dali
 * @Date 2021/10/18 21:05
 * @Version 1.0
 * @Description: JAVA 8直接用流的方法：将list转换为map的方法
 */
public class listToMap_2 {
    public static void main(String[] args) {
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(new Movie(1, "长津湖"));
        movies.add(new Movie(2, "我和我的父辈"));

/*        List<Object> collect = movies.stream().map(movie -> {
            HashMap<Integer, Movie> maps = new HashMap<>();
            maps.put(movie.getRank(),movie);
            return maps;
        }).collect(Collectors.toList());
        System.out.println(collect);*/

        Map<Integer, Movie> collect = movies.stream().collect(Collectors.toMap(Movie::getRank, p -> p));
        System.out.println(collect);
        System.out.println(collect.size());

    }
}























