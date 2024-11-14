package com.dat.algorithm.leetcode;

public class SortPeople {
    public static void main(String[] args) {
String[] names = new String[]{"Alex", "Ben", "Charlie", "David", "Eva", "Frank"};
        int[] heights = new int[]{5, 3, 2, 6, 4, 1};
        SortPeople sortPeople = new SortPeople();
        String[] res = sortPeople.sortPeople(names, heights);
        for (String name : res) {
            System.out.println(name);
        }
    }
    public String[] sortPeople(String[] names, int[] heights) {
        sort(names, heights, 0, names.length - 1);

        return names;
    }

    private void sort(String[] names, int[] heights, int l, int r) {
        if (l < r) {
            int m = l + (r - l)/2;
            sort(names, heights, l, m);
            sort(names, heights,m + 1, r);
            merge(names, heights, l, m, r);
        }
    }

    private void merge(String[] names, int[] heights, int l, int m, int r) {
        int leftN = m - l + 1;
        int rightN = r - m;
        int[] left = new int[leftN];
        int[] right = new int[rightN];

        String[] leftNames = new String[leftN];
        String[] rightNames = new String[rightN];

        for (int i = 0; i < leftN; i++) {
            left[i] = heights[i + l];
            leftNames[i] = names[i + l];
        }

        for (int i = 0; i < rightN; i++) {
            right[i] = heights[m + i + 1];
            rightNames[i] = names[m + 1 + i];
        }

        int i = 0;
        int j = 0;
        int k = l;
        while (i < leftN && j < rightN) {
            if (left[i] > right[j]) {
                heights[k] = left[i];
                names[k] = leftNames[i];
                i++;
            } else {
                heights[k] = right[j];
                names[k] = rightNames[j];
                j++;
            }
            k++;
        }

        while (i < leftN) {
            heights[k] = left[i];
            names[k] = leftNames[i];
            i++;
            k++;
        }

        while (j < rightN) {
            heights[k] = right[j];
            names[k] = rightNames[j];
            j++;
            k++;
        }
    }
}
/*
0 1 2 3 4 5
m = 2
2 - 0
 */