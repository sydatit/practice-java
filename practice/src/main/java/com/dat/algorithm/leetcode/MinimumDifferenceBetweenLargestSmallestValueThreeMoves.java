package com.dat.algorithm.leetcode;

import java.util.Arrays;

public class MinimumDifferenceBetweenLargestSmallestValueThreeMoves {
    public static void main(String[] args) {

    }
    public int minDifference(int[] nums) {
        if (nums.length <= 4) {
            return 0;
        }
        Arrays.sort(nums);
        int n = nums.length;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            res = Math.min(res, nums[n - 4 + i] - nums[i]);
        }
        return res;
    }
}
