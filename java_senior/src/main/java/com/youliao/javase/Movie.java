package com.youliao.javase;

import java.util.Objects;

/**
 * @Author Dali
 * @Date 2021/10/18 21:03
 * @Version 1.0
 * @Description
 */
public class Movie {

    private Integer rank;
    private String description;

    public Movie(Integer rank, String description) {
        super();
        this.rank = rank;
        this.description = description;
    }

    public Integer getRank() {
        return rank;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "rank=" + rank +
                ", description='" + description + '\'' +
                '}';
    }
}
