package com.dat.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

public class FlipColumnsMaximumNumberEqualRows {
    public static void main(String[] args) {
        FlipColumnsMaximumNumberEqualRows flipColumnsMaximumNumberEqualRows = new FlipColumnsMaximumNumberEqualRows();
        int[][] matrix = new int[][]{{0,0,0}, {0,0,1}, {1,1,0}};
        System.out.println(flipColumnsMaximumNumberEqualRows.maxEqualRowsAfterFlips(matrix));
    }

    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        Map<String, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            if (matrix[i][0] == 1) {
                for (int j = 0; j < m; j++) {
                    sb.append(matrix[i][j] == 0 ? 1 : 0);
                }
            } else {
                for (int j = 0; j < m; j++) {
                    sb.append(matrix[i][j]);
                }
            }
            int count = map.compute(sb.toString(), (k, v) -> (v == null) ? 1 : v + 1);
            res = Math.max(res, count);
        }
//        for (int value : map.values()) {
//            res += value >= 2 ? value : 0;
//        }
        return res;
    }
}
