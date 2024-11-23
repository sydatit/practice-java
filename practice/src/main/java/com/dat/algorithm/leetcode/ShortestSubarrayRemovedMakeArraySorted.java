package com.dat.algorithm.leetcode;

import java.util.Stack;

public class ShortestSubarrayRemovedMakeArraySorted {
    public static void main(String[] args) {
        ShortestSubarrayRemovedMakeArraySorted shortestSubarrayRemovedMakeArraySorted = new ShortestSubarrayRemovedMakeArraySorted();
        int[] arr = {1,2,3,10,0,7,8,9};
        System.out.println(shortestSubarrayRemovedMakeArraySorted.findLengthOfShortestSubarray(arr));
    }
    public int findLengthOfShortestSubarray(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            while (!stack.empty() && arr[stack.peek()] > arr[i] && i - stack.peek() >= stack.size()) {
                stack.pop();
            }
            stack.push(i);
        }

        return n - stack.size();
    }
}
