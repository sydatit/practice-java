package com.dat.algorithm.leetcode;

import java.util.Arrays;

public class SortArrayIncreasingFrequency {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2, 2, 2, 3};
        SortArrayIncreasingFrequency sortArrayIncreasingFrequency = new SortArrayIncreasingFrequency();
        int[] res = sortArrayIncreasingFrequency.frequencySort(nums);
        System.out.println(Arrays.toString(res));
    }
    
    
    private static final int MAX_VALUE = 100;
    public int[] frequencySort(int[] nums) {
        int[] freqs = new int[202];
        for (int num: nums) {
            freqs[num + MAX_VALUE] += 1;
        }
        sortFre(nums, freqs, 0, nums.length - 1);
        return nums;
    }

    private void sortFre(int[] nums, int[] freqs, int l, int r) {
        if (l < r) {
            int m = l + (r - l)/2;
            sortFre(nums, freqs, l, m);
            sortFre(nums, freqs, m + 1, r);
            mergeFre(nums, freqs, l, m, r);
        }
    }

    private void mergeFre(int[] nums, int[] freqs, int l, int m, int r) {
        int leftLength = m - l + 1;
        int rightLength = r - m;

        int[] leftArr = new int[leftLength];
        int[] rightArr = new int[rightLength];

        for (int i = 0; i < leftLength; i++) {
            leftArr[i] = nums[i + l];
        }
        for (int j = 0; j < rightLength; j++) {
            rightArr[j] = nums[j + m + 1];
        }

        int i = 0;
        int j = 0;
        int k = l;
        while (i < leftLength && j < rightLength) {
            if (freqs[leftArr[i] + MAX_VALUE] < freqs[rightArr[j] + MAX_VALUE]) {
                nums[k++] = leftArr[i++];
            } else if (freqs[leftArr[i] + MAX_VALUE] > freqs[rightArr[j] + MAX_VALUE]) {
                nums[k++] = rightArr[j++];
            } else {
                if (leftArr[i] >= rightArr[j]) {
                    nums[k++] = leftArr[i++];
                } else {
                    nums[k++] = rightArr[j++];
                }
            }
        }

        while (i < leftLength) {
            nums[k++] = leftArr[i++];
        }

        while (j < rightLength) {
            nums[k++] = rightArr[j++];
        }
    }
}
