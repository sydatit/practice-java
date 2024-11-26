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
        int[] counts = new int[n];

        for (int[] edge : edges) {
            counts[edge[1]]++;
        }
        int count = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (counts[i] == 0) {
                count++;
                res = i;
            }
        }
        return count > 1 ? -1 : res;
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
