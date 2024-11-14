package com.dat.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestSquareStreakArray {
    public static void main(String[] args) {
        int[] nums = {2,3,5,6,7};
        System.out.println(new LongestSquareStreakArray().longestSquareStreak(nums));
    }
    public int longestSquareStreak(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        Arrays.sort(nums);
        int max = -1;
        for (int num :nums) {
            int longestSquareSteak = traverseValue(num, set, 1);
            if (longestSquareSteak != 1) {
                max = Math.max(max, longestSquareSteak);
            }
        }
        return max;
    }

    private int traverseValue(int num, Set<Integer> set, int length) {
        int x = (int) Math.sqrt(num);
        if (x * x == num && set.contains(x)) {
            return traverseValue(x, set, length + 1);
        }

        return length;
    }
}
