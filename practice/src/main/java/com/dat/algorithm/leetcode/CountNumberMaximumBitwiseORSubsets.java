package com.dat.algorithm.leetcode;

public class CountNumberMaximumBitwiseORSubsets {
    public static void main(String[] args) {
        CountNumberMaximumBitwiseORSubsets countNumberMaximumBitwiseORSubsets = new CountNumberMaximumBitwiseORSubsets();
        System.out.println(countNumberMaximumBitwiseORSubsets.countMaxOrSubsets(new int[]{3,2,1,5}));
    }
    private int count;
    private int maxNum;
    public int countMaxOrSubsets(int[] nums) {
        maxNum = 0;
        count = 0;
        for (int num :nums) {
            maxNum |= num;
        }
        backTrack(0, nums.length, nums, 0);
        return count;
    }

    private void backTrack(int i, int n, int[] nums, int orValue) {
        for (int j = 0; j <= 1 ; j++) {
            if (j == 1) {
                orValue |= nums[i];
            }
            if (i == n - 1) {
                checkMaxBitwiseOr(orValue);
            } else {
                backTrack(i + 1, n, nums, orValue);
            }
        }
    }

    private void checkMaxBitwiseOr(int orValue) {
        if (orValue == maxNum) {
            count++;
        }
    }
}
