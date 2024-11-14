package com.dat.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

public class MagicSquaresGrid {
    public static void main(String[] args) {
        MagicSquaresGrid magicSquaresGrid = new MagicSquaresGrid();
        int[][] grid = new int[][]{
                {9,9,5,1,9,5,5,7,2,5},
                {9,1,8,3,4,6,7,2,8,9},
                {4,1,1,5,9,1,5,9,6,4},
                {5,5,6,7,2,8,3,4,0,6},
                {1,9,1,8,3,1,4,2,9,4},
                {2,8,6,4,2,7,3,2,7,6},
                {9,2,5,0,7,8,2,9,5,1},
                {2,1,4,4,7,6,2,4,3,8},
                {1,2,5,3,0,5,10,8,5,2},
                {6,9,6,8,8,4,3,6,0,9}
        };
        System.out.println(magicSquaresGrid.numMagicSquaresInside(grid));
    }

    public int numMagicSquaresInside(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if (n < 3 || m < 3) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i <= n - 3; i++) {
            for (int j = 0; j <= m - 3; j++) {
                if (isMagicSquares(grid, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isMagicSquares(int[][] grid, int i, int j) {
        int n = i + 2;
        int m = j + 2;
        if (grid[i + 1][j + 1] != 5)
            return false;

        int totalFirstColumn = grid[i][j] + grid[i + 1][j] + grid[i + 2][j];
        int totalThirdColumn = grid[i][m] + grid[i + 1][m] + grid[i + 2][m];
        if (totalThirdColumn != 15 || totalFirstColumn != 15) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        for (int x = i; x <= n; x++) {
            int total = 0;
            for (int y = j; y <= m; y++) {
                int value = grid[x][y];
                if (set.contains(value) || value > 9 || value < 1) {
                    return false;
                }
                set.add(value);
                if ((x == i || x == n) && (y == j || y == m) && value % 2 != 0) {
                    return false;
                }
                if ((((x == i || x == n) && y == j + 1) || (x == i + 1 && (y == j || y == n))) && value % 2 == 0) {
                    return false;
                }
                total += value;
            }
            if (total != 15) {
                return false;
            }
        }

        return true;
    }
}
