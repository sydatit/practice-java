package com.dat.algorithm.leetcode;

import java.util.Arrays;

public class RotatingBox {
    public static void main(String[] args) {
        RotatingBox rotatingBox = new RotatingBox();
        char[][] box = {{'#', '#', '*', '.', '*', '.'},
                        {'#', '#', '#', '*', '.', '.'},
                        {'#', '#', '#', '.', '#', '.'}};
        char[][] res = rotatingBox.rotateTheBox(box);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
    public char[][] rotateTheBox(char[][] box) {
        int n = box.length;
        int m = box[0].length;
        char[][] res = new char[m][n];
//        for (int i = 0; i < m; i++) {
//            Arrays.fill(res[i], '.');
//        }
        for (int i = 0; i < n; i++) {
            int b = n - i - 1;
            int prevEmt = -1;
            int countS = 0;
            for (int j = m - 1; j >= 0; j--) {
                char c = box[i][j];
                res[j][b] = '.';
                switch (c) {
                    case '.':
                        prevEmt = prevEmt == -1 ? j : prevEmt;
                        break;
                    case '#':
                        prevEmt = prevEmt == -1 ? j : prevEmt;
                        countS++;
                        break;
                    default:
                        res[j][b] = '*';
                        countS = fillStones(countS, res, prevEmt, b);
                        prevEmt = -1;
                        break;
                }
            }
            fillStones(countS, res, prevEmt, b);
        }

        return res;
    }

    private static int fillStones(int countS, char[][] res, int prevEmt, int b) {
        while (countS > 0 && prevEmt >= 0) {
            res[prevEmt--][b] = '#';
            countS--;
        }
        return countS;
    }
}
