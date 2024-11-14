package com.dat.algorithm.leetcode;

import java.util.Stack;

public class MaximumWidthRamp {
    public static void main(String[] args) {
        MaximumWidthRamp maximumWidthRamp = new MaximumWidthRamp();
        int[] nums = {9,8,1,0,1,9,4,0,4,1};
        System.out.println(maximumWidthRamp.maxWidthRamp(nums));
    }
    public int maxWidthRamp(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            if (stack.isEmpty() || nums[stack.peek()] > nums[i]) {
                stack.push(i);
            }
        }
        int res = 0;
        for (int i = nums.length - 1; i >= 1 ; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                res = Math.max(res, i - stack.pop());
            }
        }
        return res;
    }
}
