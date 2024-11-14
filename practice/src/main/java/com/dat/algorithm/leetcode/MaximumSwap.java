package com.dat.algorithm.leetcode;

import java.util.Stack;

public class MaximumSwap {
    public static void main(String[] args) {
        MaximumSwap maximumSwap = new MaximumSwap();
        System.out.println(maximumSwap.maximumSwap(10909091));
    }
    public int maximumSwap(int num) {
        String s = num + "";
        char[] chars = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        boolean exist = false;
        for (int i = 0; i < chars.length; i++) {
            while (!stack.isEmpty() && chars[stack.peek()] >= chars[i] && !exist) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                stack.push(i);
            } else if (chars[stack.peek()] <= chars[i]) {
                exist = true;
                stack.push(i);
            }
        }

//        System.out.println(stack);
        if (stack.size() <= 1) {
            return num;
        }
        int a = stack.pop();
        int b = stack.pop();
        while (!stack.isEmpty()) {
            b = stack.pop();
        }
        char temp = chars[a];
        chars[a] = chars[b];
        chars[b] = temp;

        return Integer.parseInt(new String(chars));
    }
}
