package com.codescv.example.variance;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by czzha on 12/23/16.
 */
public class Functional {
    public static void main(String[] args) {
        List<String> a = Arrays.asList("a", "b", "aa", "bb", "ccc", "ddd");
        Map<Integer, List<String>> collected = a.stream().collect(Collectors.groupingBy(String::length));
        collected.forEach((length, strs) -> {
            System.out.println(length+ ":" + strs);
        });
    }
}
