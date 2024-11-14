package com.dat.algorithm.leetcode;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeleteNodesAndReturnForest {
    public static void main(String[] args) {
        DeleteNodesAndReturnForest deleteNodesAndReturnForest = new DeleteNodesAndReturnForest();
        TreeNode root = deleteNodesAndReturnForest.new TreeNode(1);
        TreeNode left = deleteNodesAndReturnForest.new TreeNode(2);
        TreeNode right = deleteNodesAndReturnForest.new TreeNode(3);
        root.left = left;
        root.right = right;
        TreeNode leftLeft = deleteNodesAndReturnForest.new TreeNode(4);
        TreeNode leftRight = deleteNodesAndReturnForest.new TreeNode(5);
        left.left = leftLeft;
        left.right = leftRight;
        TreeNode rightLeft = deleteNodesAndReturnForest.new TreeNode(6);
        TreeNode rightRight = deleteNodesAndReturnForest.new TreeNode(7);
        right.left = rightLeft;
        right.right = rightRight;
        int[] to_delete = {3, 5};
        List<TreeNode> result = deleteNodesAndReturnForest.delNodes(root, to_delete);
        System.out.println(result);
    }
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> set = new HashSet<>();
        for (int i : to_delete) {
            set.add(i);
        }
        List<TreeNode> result = new ArrayList<>();

        deleteNodes(root, set, result, true);
        return result;
    }

    private void deleteNodes(TreeNode node, Set<Integer> set, List<TreeNode> result, boolean isRoot) {
        if (node == null) {
            return;
        }
        if (set.contains(node.val)) {
            deleteNodes(node.left, set, result, true);
            deleteNodes(node.right, set, result, true);
            return;
        }
        if (isRoot) {
            result.add(node);
        }
        if (node.left != null && set.contains(node.left.val)) {
            TreeNode left = node.left;
            node.left = null;
            deleteNodes(left, set, result, false);
        }
        if (node.right != null && set.contains(node.right.val)) {
            TreeNode right = node.right;
            node.right = null;
            deleteNodes(right, set, result, false);
        }
        deleteNodes(node.left, set, result, false);
        deleteNodes(node.right, set, result, false);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode() {}
        public TreeNode(int val) { this.val = val; }
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
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
