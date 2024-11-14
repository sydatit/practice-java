package com.dat.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class CombinationSumII {
    public static void main(String[] args) {
        CombinationSumII combinationSumII = new CombinationSumII();
        int[] candidates = {1, 2, 2, 5};
        int target = 5;
        List<List<Integer>> res = combinationSumII.combinationSum2(candidates, target);
        for (List<Integer> list : res) {
            System.out.println(list);
        }
    }
    private Set<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new HashSet<>();
        LinkedList<Integer> listIndexes = new LinkedList<>();
        Arrays.sort(candidates);
        Try(0, candidates, 0, target, listIndexes);
        return new ArrayList<>(res);
    }

    private void Try(int i, int[] candidates, int total, int target, LinkedList<Integer> list) {
        if (total == target) {
            saveCombination(list);
            return;
        }
        if (i == candidates.length) {
            return;
        }

        for (int j = 0; j < 2; j++) {
            int value = candidates[i] * j;
            if (j != 0) {
                list.addLast(value);
                total += value;
                if (total <= target) {
                    Try(i + 1, candidates, total, target, list);
                }
                total -= value;
                list.removeLast();
            } else {
                Try(i + 1, candidates, total, target, list);
            }
        }
    }

    private void saveCombination(List<Integer> list) {
        List<Integer> newList = new LinkedList<>();
        newList.addAll(list);
        res.add(newList);
    }
}
