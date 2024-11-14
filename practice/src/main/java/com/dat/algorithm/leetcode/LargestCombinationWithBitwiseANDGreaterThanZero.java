package com.dat.algorithm.leetcode;

import java.util.Arrays;

public class LargestCombinationWithBitwiseANDGreaterThanZero {
    public static void main(String[] args) {
        LargestCombinationWithBitwiseANDGreaterThanZero largestCombinationWithBitwiseANDGreaterThanZero = new LargestCombinationWithBitwiseANDGreaterThanZero();
        int[] candidates = {16,17,71,62,12,24,14};
        System.out.println(largestCombinationWithBitwiseANDGreaterThanZero.largestCombination(candidates));
    }
    public int largestCombination(int[] candidates) {
        int max = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int can : candidates) {
                count += (can & (1 << i)) != 0 ? 1 : 0;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
