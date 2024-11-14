package com.dat.algorithm.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class SortJumbledNumbers {
    public static void main(String[] args) {
        int[] mapping = new int[]{7,9,4,1,0,3,8,6,2,5};
        int[] nums = new int[]{47799,19021,162535,454,95,51890378,404};
        SortJumbledNumbers sortJumbledNumbers = new SortJumbledNumbers();
        int[] res = sortJumbledNumbers.sortJumbled(mapping, nums);
        System.out.println(Arrays.toString(res));
    }


    public int[] sortJumbled(int[] mapping, int[] nums) {
        int[] mappingNums = convertNumbers(mapping, nums);
        sortByMapping(mappingNums, nums, 0, nums.length - 1);
        return nums;
    }

    private void sortByMapping(int[] mappingNums, int[] nums, int l, int r) {
        if (l < r) {
            int m = l + (r - l)/2;
            sortByMapping(mappingNums, nums, l, m);
            sortByMapping(mappingNums, nums, m + 1, r);
            mergeTwoArr(mappingNums, nums, l, m, r);
        }
    }

    private void mergeTwoArr(int[] mappingNums, int[] nums, int l, int m, int r) {
        int leftL = m - l + 1;
        int rightL = r - m;

        int[] leftArr = new int[leftL];
        int[] rightArr = new int[rightL];

        int[] leftMapArr = new int[leftL];
        int[] rightMapArr = new int[rightL];

        for (int i = 0; i < leftL; i++) {
            leftArr[i] = nums[i + l];
            leftMapArr[i] = mappingNums[i + l];
        }

        for (int i = 0; i < rightL; i++) {
            rightArr[i] = nums[i + m + 1];
            rightMapArr[i] = mappingNums[i + m + 1];
        }

        int i = 0;
        int j = 0;
        int k = l;
        while (i < leftL && j < rightL) {
            if (leftMapArr[i] <= rightMapArr[j]) {
                nums[k] = leftArr[i];
                mappingNums[k] = leftMapArr[i];
                i++;
            } else {
                nums[k] = rightArr[j];
                mappingNums[k] = rightMapArr[j];
                j++;
            }
            k++;
        }

        while (i < leftL) {
            nums[k] = leftArr[i];
            mappingNums[k] = leftMapArr[i];
            i++;k++;
        }

        while (j < rightL) {
            nums[k] = rightArr[j];
            mappingNums[k] = rightMapArr[j];
            j++;k++;
        }
    }

    private int[] convertNumbers(int[] mapping, int[] nums) {
        int[] mappingNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            mappingNums[i] = mappingNumber(mapping, nums[i]);
        }
        return mappingNums;
    }

    private int mappingNumber(int[] mapping, int num) {
        int result = 0;
        if (num == 0) {
            return mapping[0];
        }
        StringBuilder sb = new StringBuilder(num);
        for (int i = 0; i < sb.length(); i++) {
            int digit = sb.charAt(i) - '0';
            result = result * 10 + mapping[digit];
        }

        return result;
    }
}
