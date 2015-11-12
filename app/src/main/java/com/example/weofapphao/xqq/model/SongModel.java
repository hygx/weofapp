package com.example.weofapphao.xqq.model;

import java.util.HashMap;

/**
 * Created by Rrtoyewx on 15/11/12.
 */
public class SongModel {
    public static final String id = "id";
    public static final String name = "name";
    public static final String counts = "counts";
    public static final String image = "image";

    private HashMap<String,Object> value = new HashMap<>();

    public HashMap<String, Object> getValue() {
        return value;
    }

    public void setValue(HashMap<String, Object> value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "SongModel{" +
                "value=" + value +
                '}';
    }
}
