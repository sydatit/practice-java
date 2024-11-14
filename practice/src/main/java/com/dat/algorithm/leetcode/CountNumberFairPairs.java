package com.dat.algorithm.leetcode;

import java.util.Arrays;

public class CountNumberFairPairs {
    public static void main(String[] args) {
        CountNumberFairPairs countNumberFairPairs = new CountNumberFairPairs();
        int[] nums = {0,0,0,0,0,0};
        int lower = 0;
        int upper = 0;
        System.out.println(countNumberFairPairs.countFairPairs(nums, lower, upper));
    }
    public long countFairPairs(int[] nums, int lower, int upper) {
        long res = 0;
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int upperBound = upper - nums[i];
            int lowerBound = lower - nums[i];
            int u = findUpperBound(nums, i + 1, n, upperBound);
            int l = findLowerBound(nums, i + 1, n, lowerBound);
            res += u - l;

        }
//        System.out.println(Arrays.toString(nums));

        return res;
    }

    private int findLowerBound(int[] nums, int start, int end, int target) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    private int findUpperBound(int[] nums, int start, int end, int target) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
