package com.dat.algorithm.leetcode;

import java.util.ArrayList;

public class FindChampionII {
    public static void main(String[] args) {
        FindChampionII findChampionII = new FindChampionII();
        int n = 3;
        int[][] edges = new int[][]{{0, 1}, {1, 2}, {0, 2}};
        System.out.println(findChampionII.findChampion(n, edges));
    }
    private ArrayList<Integer> adj[];
    private boolean[] visited;
    private int[] dp;
    public int findChampion(int n, int[][] edges) {
        dp = new int[n];
        adj = new ArrayList[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
        }

        for (int i = 0; i < n; i++) {
            int count = traverseDFS(i);
            if (count == n) 
                return i;
        }
        return -1;
    }

    private int traverseDFS(int u) {
        int nodes = 1;
        visited[u] = true;
        for (int v :adj[u]) {
            if (!visited[v]) {
                nodes += traverseDFS(v);
            } else {
                nodes += dp[v];
            }
        }
        dp[u] = nodes;
        return nodes;
    }
}
