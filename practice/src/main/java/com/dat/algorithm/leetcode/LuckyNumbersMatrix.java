package com.dat.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LuckyNumbersMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{3, 7, 8}, {9, 11, 13}, {15, 16, 17}};
        LuckyNumbersMatrix luckyNumbersMatrix = new LuckyNumbersMatrix();
        List<Integer> res = luckyNumbersMatrix.luckyNumbers(matrix);
        for (int i : res) {
            System.out.println(i);
        }
    }

    public List<Integer> luckyNumbers(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int maxOfMinCol = -1;
        int maxOfMinRow = -1;
        int maxOfMinV = Integer.MIN_VALUE;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int x = -1;
            int y = -1;
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                    x = i;
                    y = j;
                }
            }
            if (min > maxOfMinV) {
                maxOfMinV = min;
                maxOfMinRow = x;
                maxOfMinCol = y;
            }
        }
        boolean isLucky = true;
        for (int i = 0; i < n; i++) {
            if (matrix[i][maxOfMinCol] > maxOfMinV) {
                isLucky = false;
                break;
            }
        }
        if (isLucky) {
            res.add(maxOfMinV);
        }
        return res;
    }
}
