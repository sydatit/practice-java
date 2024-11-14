package com.dat.algorithm.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumNumberPushesTypeWordII {
    public static void main(String[] args) {
        MinimumNumberPushesTypeWordII minimumNumberPushesTypeWordII = new MinimumNumberPushesTypeWordII();
        System.out.println(minimumNumberPushesTypeWordII.minimumPushes("aabbccddeeffgghhiiiiii"));
    }
    private static final int NUMBER_OF_KEY_CONTAINERS = 8;
    public int minimumPushes(String word) {
        int numberOfKeyFilledFirstChar = 0;
        int numberOfKeyFilledSecondChar = 0;
        int numberOfKeyFilledThirdChar = 0;
        int res = 0;
        int[] countC = new int[26];
        for (char c :word.toCharArray()) {
            countC[c - 'a']++;
        }
        Arrays.sort(countC);
        for (int i = countC.length - 1; i >= 0 && countC[i] != 0; i--) {
            int numberOfChars = countC[i];
            int numberOfExsistCh = -1;

            if (numberOfKeyFilledFirstChar < NUMBER_OF_KEY_CONTAINERS) {
                numberOfExsistCh = 0;
                numberOfKeyFilledFirstChar++;
            } else if (numberOfKeyFilledSecondChar < NUMBER_OF_KEY_CONTAINERS) {
                numberOfExsistCh = 1;
                numberOfKeyFilledSecondChar++;
            } else if (numberOfKeyFilledThirdChar < NUMBER_OF_KEY_CONTAINERS) {
                numberOfExsistCh = 2;
                numberOfKeyFilledThirdChar++;
            }
            numberOfExsistCh++;
            res += numberOfExsistCh * numberOfChars;
        }

        return res;
    }
}
