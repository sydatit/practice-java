package com.dat.algorithm.leetcode;

public class NumberGoodLeafNodesPairs {
    public static void main(String[] args) {
        NumberGoodLeafNodesPairs numberGoodLeafNodesPairs = new NumberGoodLeafNodesPairs();
        TreeNode root = numberGoodLeafNodesPairs.new TreeNode(1);
        root.left = numberGoodLeafNodesPairs.new TreeNode(2);
        root.right = numberGoodLeafNodesPairs.new TreeNode(3);
        root.left.left = numberGoodLeafNodesPairs.new TreeNode(4);
        root.left.right = numberGoodLeafNodesPairs.new TreeNode(5);
        root.right.left = numberGoodLeafNodesPairs.new TreeNode(6);
        root.right.right = numberGoodLeafNodesPairs.new TreeNode(7);
        root.left.left.left = numberGoodLeafNodesPairs.new TreeNode(8);
        root.left.left.right = numberGoodLeafNodesPairs.new TreeNode(9);
        root.left.right.left = numberGoodLeafNodesPairs.new TreeNode(10);
        root.left.right.right = numberGoodLeafNodesPairs.new TreeNode(11);
        root.right.left.left = numberGoodLeafNodesPairs.new TreeNode(12);
        root.right.left.right = numberGoodLeafNodesPairs.new TreeNode(13);
        root.right.right.left = numberGoodLeafNodesPairs.new TreeNode(14);
        root.right.right.right = numberGoodLeafNodesPairs.new TreeNode(15);
        System.out.println(numberGoodLeafNodesPairs.countPairs(root, 3));
    }
    private int countP;
    private final int MAX_DISTANCE = 10;
    public int countPairs(TreeNode root, int distance) {
        countP = 0;
        dfs(root, distance);
        return countP;
    }
    private int[] dfs(TreeNode node, int distance) {
        if (node == null) {
            return new int[MAX_DISTANCE + 1];
        }

        if (node.left == null && node.right == null) {
            int[] res = new int[MAX_DISTANCE + 1];
            res[1] = 1;
            return res;
        }

        int[] left = dfs(node.left, distance);
        int[] right = dfs(node.right, distance);

        for (int i = 1; i <= distance; i++) {
            for (int j = 1; j <= distance - i; j++) {
                countP += left[i] * right[j];
            }
        }

        int[] res = new int[MAX_DISTANCE + 1];
        for (int i = 1; i < MAX_DISTANCE; i++) {
            res[i + 1] = left[i] + right[i];
        }
        return res;
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
