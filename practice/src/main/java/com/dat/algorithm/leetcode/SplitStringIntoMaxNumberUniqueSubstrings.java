package com.dat.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

public class SplitStringIntoMaxNumberUniqueSubstrings {
    public static void main(String[] args) {
        SplitStringIntoMaxNumberUniqueSubstrings splitStringIntoMaxNumberUniqueSubstrings = new SplitStringIntoMaxNumberUniqueSubstrings();
        System.out.println(splitStringIntoMaxNumberUniqueSubstrings.maxUniqueSplit("ababccc"));
    }
    private int max;
    public int maxUniqueSplit(String s) {
        max = 0;
        int length = s.length();
        Set<String>  set = new HashSet<>();
        findMaxUniqueSplit(s, 0, length, set, 0);
        return max;
    }

    private void findMaxUniqueSplit(String s, int i, int length, Set<String> set, int count) {
        if (i == length) {
            max = Math.max(max, count);
            return;
        }
        for (int j = i + 1; j <= length; j++) {
            String newS = s.substring(i, j);
            if (!set.contains(newS)) {
                count++;
                set.add(newS);
                findMaxUniqueSplit(s, j, length, set, count);
                count--;
                set.remove(newS);
            }
        }
    }

}
