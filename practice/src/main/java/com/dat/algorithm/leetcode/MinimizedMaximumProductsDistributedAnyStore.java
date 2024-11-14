package com.dat.algorithm.leetcode;

import java.util.Arrays;

public class MinimizedMaximumProductsDistributedAnyStore {
    public static void main(String[] args) {
        MinimizedMaximumProductsDistributedAnyStore minimizedMaximumProductsDistributedAnyStore = new MinimizedMaximumProductsDistributedAnyStore();
        int n = 5;
        int[] quantities = {15,10,10};
        System.out.println(minimizedMaximumProductsDistributedAnyStore.minimizedMaximum(n, quantities));
    }
    public int minimizedMaximum(int n, int[] quantities) {
        int low = 1;
        int high = Arrays.stream(quantities).max().getAsInt();
        while (low < high) {
            int m = low + (high - low)/2;
            int needed = 0;
            for (int q :quantities) {
                needed += (q + m - 1)/m;
            }
            if (needed > n) {
                low = m + 1;
            } else
                high = m;
        }
        return low;
    }
}
