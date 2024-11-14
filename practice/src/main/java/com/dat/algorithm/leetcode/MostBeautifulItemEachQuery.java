package com.dat.algorithm.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class MostBeautifulItemEachQuery {
    public static void main(String[] args) {
        MostBeautifulItemEachQuery mostBeautifulItemEachQuery = new MostBeautifulItemEachQuery();
        int[][] items = {{1,2},{3,2},{2,4},{5,6},{3,5}};
        int[] queries = {1,2,3,4,5,6, 0};
        System.out.println(Arrays.toString(mostBeautifulItemEachQuery.maximumBeauty(items, queries)));
    }
    public int[] maximumBeauty(int[][] items, int[] queries) {
        items = Arrays.stream(items).sorted(Comparator.comparingInt(a -> a[0])).toArray(int[][]::new);


        int n = queries.length;
        int[] res = new int[n];
        int max = 0;
        for (int i = 0; i < queries.length; i++) {
            max = Math.max(max, queries[i]);
            queries[i] = max;
        }
        for (int i = 0; i < n; i++) {
            int q = queries[i];
            int j = findIndex(items, q);
            if (items[j][0] <= q) {
                res[i] = items[j][1];
            }
            System.out.println(j);
        }
        return res;
    }

    private int findIndex(int[][] items, int q) {
        int l = 0;
        int r = items.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (items[m][0] < q) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
}
