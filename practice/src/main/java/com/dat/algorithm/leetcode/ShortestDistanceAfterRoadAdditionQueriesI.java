package com.dat.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class ShortestDistanceAfterRoadAdditionQueriesI {
    public static void main(String[] args) {
        ShortestDistanceAfterRoadAdditionQueriesI shortestDistanceAfterRoadAdditionQueriesI = new ShortestDistanceAfterRoadAdditionQueriesI();
        int n = 5;
        int[][] queries = new int[][]{{2, 4}, {0, 2}, {0, 4}};
        int[] result = shortestDistanceAfterRoadAdditionQueriesI.shortestDistanceAfterQueries(n, queries);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
    private PriorityQueue<Integer> adj[];
    private boolean[] visited;
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int size = queries.length;
        int[] res = new int[size];
        adj = new PriorityQueue[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new PriorityQueue<>((a, b) -> b - a);
        }
        for (int i = 0; i < n - 1; i++) {
            adj[i].add(i + 1);
        }
        for (int i = 0; i < size; i++) {
            int[] q = queries[i];
            adj[q[0]].add(q[1]);
            int minP = bfs(n - 1);
            Arrays.fill(visited, false);
            res[i] = minP;
        }
        return res;
    }

    private int bfs(int destination) {
        Queue<Integer> queue = new LinkedList<>();
        visited[0] = true;
        queue.add(0);
        int count = 0;
        int res = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            int head = queue.poll();
            count++;
            for (int v :adj[head]) {
                res = Math.min(count, res);
                if (!visited[v]) {
                    queue.offer(v);
                    visited[v] = true;
                }
            }
        }
        return res;
    }
}
