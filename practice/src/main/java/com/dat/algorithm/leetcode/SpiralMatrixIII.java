package com.dat.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrixIII {
    public static void main(String[] args) {
        SpiralMatrixIII spiralMatrixIII = new SpiralMatrixIII();
        int rows = 5;
        int cols = 6;
        int rStart = 1;
        int cStart = 4;
        int[][] result = spiralMatrixIII.spiralMatrixIII(rows, cols, rStart, cStart);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i][0] + " " + result[i][1]);
        }
    }
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] direction = {{0,1}, {1, 0}, {0, -1}, {-1, 0}};
        int numSteps = 1;
        int totalCells = rows * cols;
        List<int[]> result = new ArrayList<>();
        int r = rStart, c = cStart;
        int d = 0;

        while (result.size() < totalCells) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < numSteps; j++) {
                    if (0 <= r && r < rows && 0 <= c && c < cols) {
                        result.add(new int[]{r, c});
                    }

                    r += direction[d][0];
                    c += direction[d][1];
                }
                d = (d + 1) % 4;
            }
            numSteps++;
        }
        return convertListToArray(result);
    }

    private int[][] convertListToArray(List<int[]> result) {
        int[][] arr = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            arr[i] = result.get(i);
        }
        return arr;
    }
}
