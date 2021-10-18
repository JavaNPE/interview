package com.youliao.javase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;

/**
 * @Author Dali
 * @Date 2021/10/18 21:05
 * @Version 1.0
 * @Description: 使用传统的方法：将list转换为map的方法
 */
public class ListToMap_1 {
    public static void main(String[] args) {
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(new Movie(1, "长津湖"));
        movies.add(new Movie(2, "我和我的父辈"));

        HashMap<Integer, Movie> mappedMovies = new HashMap<>();
        for (Movie movie : movies) {
            mappedMovies.put(movie.getRank(), movie);
            System.out.println(mappedMovies);
        }
//        Logger.info(mappedMovies);
        System.out.println(mappedMovies.size());
    }
}























