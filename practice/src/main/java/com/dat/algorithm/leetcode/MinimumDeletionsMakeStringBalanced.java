package com.dat.algorithm.leetcode;

public class MinimumDeletionsMakeStringBalanced {
    public static void main(String[] args) {
        MinimumDeletionsMakeStringBalanced minimumDeletionsMakeStringBalanced = new MinimumDeletionsMakeStringBalanced();
        System.out.println(minimumDeletionsMakeStringBalanced.minimumDeletions("baababbaabbaaabaabbabbbabaaaaaabaabababaaababbb"));
    }
    public int minimumDeletions(String s) {
        char[] chars = s.toCharArray();
        if (chars.length == 1) {
            return 0;
        }
        int a = 0;
        int b = 0;
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'b') {
                if (a != 0 && b != 0) {
                    count += Math.min(a, b);
                    a = 0;
                    b = 0;
                }
                b++;
            } else if (b != 0) {
                a++;
            }
        }
        if (a != 0 && b != 0) {
            count += Math.min(a, b);
        }
        return count;
    }
}
