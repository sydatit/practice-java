package com.dat.algorithm.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaximumSumDistinctSubarraysWithLengthK {
    public static void main(String[] args) {
MaximumSumDistinctSubarraysWithLengthK maximumSumDistinctSubarraysWithLengthK = new MaximumSumDistinctSubarraysWithLengthK();
        int[] nums = {9,9,9,1,2,3};
        int k = 3;
        System.out.println(maximumSumDistinctSubarraysWithLengthK.maximumSubarraySum(nums, k));
    }
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        long sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        long max = 0;
        if (map.size() == k) {
            max = sum;
        }
        for (int i = 1; i - 1 + k < nums.length; i++) {
            sum += nums[i - 1 + k];
            sum -= nums[i - 1];
            map.put(nums[i - 1 + k], map.getOrDefault(nums[i - 1 + k], 0) + 1);
            if (map.get(nums[i - 1]) == 1) {
                map.remove(nums[i - 1]);
            } else {
                map.put(nums[i - 1], map.get(nums[i - 1]) - 1);
            }
            if (map.size() == k) {
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}
