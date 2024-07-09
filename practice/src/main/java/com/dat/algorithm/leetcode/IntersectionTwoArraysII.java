package com.dat.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionTwoArraysII {
    public static void main(String[] args) {

    }
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] temp;
        if (nums1.length > nums2.length) {
            temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (int num: nums2) {
            if (map.containsKey(num)) {
                list.add(num);
                int count = map.get(num);
                if (count == 1) {
                    map.remove(num);
                } else
                    map.put(num, --count);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
