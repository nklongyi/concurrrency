package com.nklongyi.example.immutable;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.Map;

/**
 * Created by longyi on 2018-06-26.
 */
@Slf4j
public class ImmutableExample3 {
    private final static Integer a = 1;
    private final static String b = "2";
    private static Map<Integer,Integer> map = Maps.newHashMap();


    static {
        map.put(1,2);
        map.put(2,3);
        map.put(5,6);
        map = Collections.unmodifiableMap(map);
    }

    public static void main(String[] args) {
//        map = new HashMap<>();
        map.put(1,3);
        log.info("{}",map.get(1));
    }
}
