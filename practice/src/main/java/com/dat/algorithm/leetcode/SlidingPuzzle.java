package com.dat.algorithm.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SlidingPuzzle {
    public static void main(String[] args) {
        SlidingPuzzle slidingPuzzle = new SlidingPuzzle();
        int[][] board = {{1, 2, 3}, {4, 0, 5}};
        System.out.println(slidingPuzzle.slidingPuzzle(board));
    }
    public int slidingPuzzle(int[][] board) {
        int[][] dir = {
                {1, 3},
                {0, 2, 4},
                {1, 5},
                {0, 4},
                {1, 3, 5},
                {2, 4}};
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        String target = "123450";
        StringBuilder first = new StringBuilder().append(board[0][0])
                .append(board[0][1])
                .append(board[0][2])
                .append(board[1][0])
                .append(board[1][1])
                .append(board[1][2]);
        visited.add(first.toString());
        queue.offer(first.toString());
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size --> 0) {
                String head = queue.poll();
                if (head.equals(target)) {
                    return steps;
                }
                int indexOf0 = head.indexOf('0');
                for (int nextI : dir[indexOf0]) {
                    StringBuilder sb = new StringBuilder(head);
                    char swapCh = head.charAt(nextI);
                    sb.setCharAt(nextI, '0');
                    sb.setCharAt(indexOf0, swapCh);
                    String nextState = sb.toString();
                    if (!visited.contains(nextState)) {
                        visited.add(nextState);
                        queue.offer(nextState);
                    }
                }
            }
            steps++;
        }
        return -1;

    }
}
