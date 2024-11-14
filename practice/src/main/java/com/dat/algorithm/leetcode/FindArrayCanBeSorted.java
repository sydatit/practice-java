package com.dat.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FindArrayCanBeSorted {
    public static void main(String[] args) {
        FindArrayCanBeSorted findArrayCanBeSorted = new FindArrayCanBeSorted();
        int[] nums = {3,16,8,4,2};
        System.out.println(findArrayCanBeSorted.canSortArray(nums));
    }
//    public boolean canSortArray(int[] nums) {
//        int[] bits = convertNumsToBits(nums);
//        System.out.println(Arrays.toString(bits));
//        List<int[]> combinations = new ArrayList<>();
//        for (int i = 0; i < bits.length; i++) {
//            int[] c = new int[]{nums[i], bits[i], i};
//            combinations.add(c);
//        }
//        combinations.sort(Comparator.comparingInt(a -> a[0]));
//        for (int[] c : combinations) {
//            System.out.println(Arrays.toString(c));
//        }
//        int count = 0;
//        int min = Integer.MAX_VALUE;
//        int max = Integer.MIN_VALUE;
//        int prev = combinations.get(0)[1];
//        for (int i = 0; i < bits.length; i++) {
//            int[] curr = combinations.get(i);
//            if (prev == curr[1]) {
//                count++;
//                min = Math.min(min, curr[2]);
//                max = Math.max(max, curr[2]);
//            } else {
//                if (max - min + 1!= count) {
//                    return false;
//                }
//                count = 1;
//                prev = curr[1];
//                min = curr[2];
//                max = curr[2];
//            }
//        }
//        return max - min + 1 == count;
//    }
//
//    private int[] convertNumsToBits(int[] nums) {
//        int n = nums.length;
//        int[] res = new int[n];
//        for (int i = 0; i < n; i++) {
//            res[i] = convertN(nums[i]);
//        }
//        return res;
//    }
//
//    private int convertN(int num) {
//        int count = 0;
//        while (num != 0) {
//            int remain = num % 2;
//            count += remain;
//            num /= 2;
//        }
//        return count;
//    }
    public boolean canSortArray(int[] nums) {
        int pmax = 0;
        int cmin = 0;
        byte cnob = 0;
        byte pnob = 0;
        for (int num :nums) {
            cnob = (byte) Integer.bitCount(num);

        }
        return true;
    }
}
/*
30 / 2 = 15 | 0
15 / 2 = 7  | 1
7  / 2 = 3  | 1
3  / 2 = 1  | 1
1  / 2 = 0  | 1
 */