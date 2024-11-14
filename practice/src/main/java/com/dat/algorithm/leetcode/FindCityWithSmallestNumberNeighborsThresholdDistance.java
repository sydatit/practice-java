package com.dat.algorithm.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindCityWithSmallestNumberNeighborsThresholdDistance {
    public static void main(String[] args) {
        FindCityWithSmallestNumberNeighborsThresholdDistance findCityWithSmallestNumberNeighborsThresholdDistance = new FindCityWithSmallestNumberNeighborsThresholdDistance();
        int n = 4;
        int[][] edges = new int[][]{{0,1,3},{1,2,1},{1,3,4},{2,3,1}};
        int distanceThreshold = 4;
        System.out.println(findCityWithSmallestNumberNeighborsThresholdDistance.findTheCity(n, edges, distanceThreshold));
    }
    private int greatestCityNumber;
    private int numberOfReachableNeighbors;
    private boolean[] visited;
    private int[] distance;
    private List<int[]> adj[];
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        adj = new ArrayList[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            int weight = edges[i][2];
            adj[from].add(new int[]{to, weight});
            adj[to].add(new int[]{from, weight});
        }
        greatestCityNumber = -1;
        numberOfReachableNeighbors = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            distance = new int[n];
            for (int j = 0; j < n; j++) {
                distance[j] = Integer.MAX_VALUE;
            }
            bfs(i, distanceThreshold);
        }
        return greatestCityNumber;
    }

    private void bfs(int u, int distanceThreshold) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{u, 0});
        visited[u] = true;
        int totalReachableNeighbors = 0;
        while (!q.isEmpty()) {
            int[] head = q.poll();
            int currentCity = head[0];
            int currDistance = head[1];
            for (int[] neighbor : adj[currentCity]) {
                int neighborCity = neighbor[0];
                int neighborDistance = neighbor[1];
                if (currDistance + neighborDistance <= distanceThreshold
                        && distance[neighborCity] > currDistance + neighborDistance && u != neighborCity) {
                    totalReachableNeighbors++;
                    distance[neighborCity] = currDistance + neighborDistance;
                    q.add(new int[]{neighborCity, currDistance + neighborDistance});
                }
            }
            if (totalReachableNeighbors >= numberOfReachableNeighbors && u < greatestCityNumber) {
                return;
            }
        }
        if (totalReachableNeighbors < numberOfReachableNeighbors) {
            numberOfReachableNeighbors = totalReachableNeighbors;
            greatestCityNumber = u;
        } else if (totalReachableNeighbors == numberOfReachableNeighbors) {
            greatestCityNumber = Math.max(greatestCityNumber, u);
        }
    }
}
