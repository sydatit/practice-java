package com.dat.algorithm.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class E2285 {
    public static void main(String[] args) {
        E2285 e2285 = new E2285();
        int n = 5;
        int[][] roads = {{0, 1}, {0, 2}, {0, 3}, {0, 4}};
        System.out.println(e2285.maximumImportance(n, roads));
    }
    public long maximumImportance(int n, int[][] roads) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int[] road : roads) {
            map.put(road[0], map.getOrDefault(road[0], 0) + 1);
            map.put(road[1], map.getOrDefault(road[1], 0) + 1);
        }
        int size = map.size();
        long res = 0;
        List<Integer> values = map.values().stream().sorted(Collections.reverseOrder())
                .toList();
        for (int i = size - 1; i >= 0; i--) {
            res += (long) values.get(i) * n--;
        }
        return res;
    }
}
