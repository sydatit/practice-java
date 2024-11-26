package com.dat.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MaximumMatrixSum {
    public static void main(String[] args) {
        MaximumMatrixSum maximumMatrixSum = new MaximumMatrixSum();
        int[][] matrix = {{1, 2, 3}, {-1, -2, -3}, {1, 2, 3}};
        System.out.println(maximumMatrixSum.maxMatrixSum(matrix));
    }
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        long res = 0;
        int maxI = Integer.MAX_VALUE;
        int countNeg = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int v = matrix[i][j];
                if (v < 0) {
                    countNeg++;
                    res += (-v);
                    maxI = Math.min(maxI, (-v));
                } else {
                    res += v;
                    maxI = Math.min(maxI, v);
                }
            }
        }
        if (countNeg % 2 != 0) {
            res = res - maxI - maxI;
        }
        return res;
    }
}
