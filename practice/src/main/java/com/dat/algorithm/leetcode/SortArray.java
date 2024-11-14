package com.dat.algorithm.leetcode;

public class SortArray {
    public static void main(String[] args) {

    }
    public int[] sortArray(int[] nums) {
        sortArray(nums, 0, nums.length - 1);
        return nums;
    }

    private void sortArray(int[] nums, int l, int r) {
        if (l < r) {
            int m  = l + (r - l)/2;
            sortArray(nums, l, m);
            sortArray(nums, m + 1, r);
            mergeArray(nums, l, m, r);
        }
    }

    private void mergeArray(int[] nums, int l, int m, int r) {
        int nL = m - l + 1;
        int nR = r - m;

        int[] lArr = new int[nL];
        int[] rArr = new int[nR];

        for (int i = 0; i < nL; i++) {
            lArr[i] = nums[i + l];
        }

        for (int i = 0; i < nR; i++) {
            rArr[i] = nums[i + m + 1];
        }

        int i = 0;
        int j = 0;
        int k = l;

        while (i < nL && j < nR) {
            if (lArr[i] <= rArr[j]) {
                nums[k++] = lArr[i++];
            } else {
                nums[k++] = rArr[j++];
            }
        }

        while (i < nL) {
            nums[k++] = lArr[i++];
        }

        while (j < nR) {
            nums[k++] = rArr[j++];
        }
    }
}
