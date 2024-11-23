package com.dat.algorithm.leetcode;

import java.util.Arrays;

public class DefuseBomb {
    public static void main(String[] args) {
        DefuseBomb defuseBomb = new DefuseBomb();
        int[] code = {2,4,9,3};
        int k = -2;
        int[] res = defuseBomb.decrypt(code, k);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] res = new int[n];
        Arrays.fill(res, 0);
        if (k == 0)
            return res;
        int window = 0;
        int x = k > 0 ? 1 : n + k;
        int y = k > 0 ? x + k - 1 : n - 1;
        for (int i = x; i <= y && x < n && y < n ; i++) {
            window += code[i];
        }
        res[0] = window;
        for (int i = 1; i < n; i++) {
            window -= code[x];
            x = x + 1 < n ? x + 1 : 0;
            y = y + 1 < n ? y + 1 : 0;
            window += code[y];
            res[i] = window;
        }

        return res;
    }
}
