package com.dat.algorithm.leetcode;

import java.util.PriorityQueue;

public class DesignStackWithIncrementOperation {
    public static void main(String[] args) {
        CustomStack customStack = new DesignStackWithIncrementOperation().new CustomStack(3);
        customStack.push(1);
        customStack.push(2);
        System.out.println(customStack.pop());
        customStack.push(2);
        customStack.push(3);
        customStack.push(4);
        customStack.increment(5, 100);
        customStack.increment(2, 100);
        System.out.println(customStack.pop());
        System.out.println(customStack.pop());
        System.out.println(customStack.pop());
        System.out.println(customStack.pop());
    }


    class CustomStack {
        private int[] stack;
        private int top = -1;
        private int[] increment;
        public CustomStack(int maxSize) {
            stack = new int[maxSize];
            increment = new int[maxSize];
        }

        public void push(int x) {
            if (top < stack.length - 1) {
                stack[++top] = x;
            }
        }

        public int pop() {
            if (top == -1) {
                return -1;
            }
            int incrementValue = increment[top];
            increment[top] = 0;
            return stack[top--] + incrementValue;
        }

        public void increment(int k, int val) {
            int min = Math.min(k - 1, top);
            for (int i = 0; i <= min; i++) {
                increment[i] += val;
            }
        }
    }
}
