package com.dat.algorithm.leetcode;

public class MinimumSwapsGroupAll1sTogetherII {
    public static void main(String[] args) {

        MinimumSwapsGroupAll1sTogetherII minimumSwapsGroupAll1sTogetherII = new MinimumSwapsGroupAll1sTogetherII();
        int[] nums = {0,1,0,1,1,0,0};
        System.out.println(minimumSwapsGroupAll1sTogetherII.minSwaps(nums));
    }
    public int minSwaps(int[] nums) {
        int sizeOfWindow = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                sizeOfWindow++;
            }
        }
        if (sizeOfWindow == 0 || sizeOfWindow == nums.length - 1) {
            return 0;
        }
        int maxOnes = 0;
        int currentOnes = 0;
        for (int i = 0; i < sizeOfWindow; i++) {
            if (nums[i] == 1) {
                currentOnes++;
            }
        }
        maxOnes = currentOnes;
        for (int i = 1; i < nums.length; i++) {
            currentOnes -= nums[i - 1] == 1 ? 1 : 0;
            if (i + sizeOfWindow - 1 < nums.length) {
                currentOnes += nums[i + sizeOfWindow - 1] == 1 ? 1 : 0;
            } else {
                int index = i + sizeOfWindow - 1 - nums.length;
                currentOnes += nums[index] == 1 ? 1 : 0;
            }
            maxOnes = Math.max(maxOnes, currentOnes);
        }
        return sizeOfWindow - maxOnes;
    }
}
