package com.dat.algorithm.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ReverseSubstringsBetweenEachPairParentheses {
    public static void main(String[] args) {
        ReverseSubstringsBetweenEachPairParentheses reverseSubstringsBetweenEachPairParentheses = new ReverseSubstringsBetweenEachPairParentheses();
        reverseSubstringsBetweenEachPairParentheses.reverseParentheses("(ed(et(oc))el)");
    }
    public String reverseParentheses(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if (c != ')') {
                stack.add(c);
            } else {
                LinkedList<Character> queue = new LinkedList<>();
                while (!stack.isEmpty() && !stack.peek().equals('(')) {
                    queue.addLast(stack.pop());
                }
                stack.pop();
                while (!queue.isEmpty()) {
                    stack.push(queue.pop());
                }
            }
        }
        char[] result = new char[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return new String(result);
    }
}
