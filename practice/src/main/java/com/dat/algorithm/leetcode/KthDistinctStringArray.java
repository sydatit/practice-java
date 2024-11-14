package com.dat.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class KthDistinctStringArray {
    public static void main(String[] args) {
        KthDistinctStringArray kthDistinctStringArray = new KthDistinctStringArray();
        String[] arr = {"d","b","c","b","c","a"};
        System.out.println(kthDistinctStringArray.kthDistinct(arr, 2));
    }
    public String kthDistinct(String[] arr, int k) {
        HashMap<String, List<Integer>> map = new LinkedHashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.get(arr[i]).add(i);
            } else {
                List<Integer> newList = new ArrayList<>();
                newList.add(i);
                map.put(arr[i], newList);
            }
        }
        int index = 0;
        for (Map.Entry<String, List<Integer>> entry: map.entrySet()) {
            if (entry.getValue().size() == 1) {
                index++;
            }
            if (index == k)
                return entry.getKey();
        }
        return "";
    }
}
