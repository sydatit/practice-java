package com.dat.algorithm.leetcode;


import java.util.ArrayList;
import java.util.List;

public class CousinsBinaryTreeII {
    public static void main(String[] args) {
        CousinsBinaryTreeII cousinsBinaryTreeII = new CousinsBinaryTreeII();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(5);
        System.out.println(cousinsBinaryTreeII.replaceValueInTree(root));
    }
    public TreeNode replaceValueInTree(TreeNode root) {
        List<List<int[]>> collectValues = new ArrayList<>();
        dfs(root, collectValues, 1, 1);
        for (List<int[]> row : collectValues) {
            for (int[] value : row) {
                System.out.println(value[0] + " " + value[1]);
            }
            System.out.println("---------------------");
        }
        return root;
    }

    private void dfs(TreeNode node, List<List<int[]>> collectValues, int side, int level) {
        if (node == null)
            return;
        List<int[]> row;
        if (collectValues.size() < level) {
            row = new ArrayList<>();
            collectValues.add(row);
        } else {
            row = collectValues.get(level - 1);
        }
        row.add(new int[]{side, node.val});
        dfs(node.left, collectValues, side * 10, level + 1);
        dfs(node.right, collectValues, side * 10 + 1, level + 1);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
