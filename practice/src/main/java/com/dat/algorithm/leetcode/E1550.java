package com.dat.algorithm.leetcode;

public class E1550 {
    public static void main(String[] args) {

    }
    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;
        for (int ele : arr) {
            if (ele % 2 == 0) {
                count = 0;
            } else {
                count++;
            }
            if (count == 3) {
                return true;
            }
        }
        return false;
    }
}
