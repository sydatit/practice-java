package com.dat.algorithm.leetcode;

public class MaximumNumberMovesGrid {
    public static void main(String[] args) {
        MaximumNumberMovesGrid maximumNumberMovesGrid = new MaximumNumberMovesGrid();
        int[][] grid = new int[][]{{3,2,4}, {2,1,9}, {1,1,7}};
        System.out.println(maximumNumberMovesGrid.maxMoves(grid));
    }
    public int maxMoves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        int max = 0;
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int maxC = 0;
                if (j - 1 >= 0 && grid[j][i] > grid[j - 1][i - 1] && dp[j - 1][i - 1] == i - 1) {
                    maxC = Math.max(maxC, dp[j - 1][i - 1] + 1);
                }
                if (j + 1 < n && grid[j][i] > grid[j + 1][i - 1] && dp[j + 1][i - 1] == i - 1) {
                    maxC = Math.max(maxC, dp[j + 1][i - 1] + 1);
                }
                if (grid[j][i] > grid[j][i - 1] && dp[j][i - 1] == i - 1) {
                    maxC = Math.max(maxC, dp[j][i - 1] + 1);
                }
                dp[j][i] = maxC;
                max = Math.max(maxC, max);
            }
        }
        System.out.println("dp: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return max;
    }
}
