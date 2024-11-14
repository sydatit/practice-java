package com.dat.algorithm.leetcode;

import java.util.PriorityQueue;

public class LongestHappyString {
    public static void main(String[] args) {
        LongestHappyString longestHappyString = new LongestHappyString();
        System.out.println(longestHappyString.longestDiverseString(1, 1, 7));
        System.out.println(longestHappyString.longestDiverseString(2, 2, 1));
        System.out.println(longestHappyString.longestDiverseString(7, 1, 0));
        System.out.println(longestHappyString.longestDiverseString(0, 8, 11));
    }
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> y[1] - x[1]);
        if (a > 0) pq.add(new int[]{0, a});
        if (b > 0) pq.add(new int[]{1, b});
        if (c > 0) pq.add(new int[]{2, c});
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int[] first = pq.poll();
            int l = sb.length();
            if (l >= 2 && sb.charAt(l - 1) == first[0] + 'a' && sb.charAt(l - 2) == first[0] + 'a') {
                if (pq.isEmpty()) break;
                int[] second = pq.poll();
                sb.append((char) (second[0] + 'a'));
                if (--second[1] > 0) pq.add(second);
                pq.add(first);
            } else {
                sb.append((char) (first[0] + 'a'));
                if (--first[1] > 0) pq.add(first);
            }
        }
        return sb.toString();
    }
}
