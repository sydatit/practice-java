package com.dat.algorithm.leetcode;

import com.dat.algorithm.leetcode.model.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StepByStepDirectionsFromBinaryTreeNodeAnother {
    public static void main(String[] args) {

    }
    Map<Integer, List<Node>> map;
    public String getDirections(TreeNode root, int startValue, int destValue) {
        map = new HashMap<>();
        buildGraph(root, map);

        return "";
    }

    private void buildGraph(TreeNode node, Map<Integer, List<Node>> map) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            List<Node> leftChildren = map.getOrDefault(node.left.val, new ArrayList<>());
            leftChildren.add(new Node(node.val, 'U'));
            map.put(node.left.val, leftChildren);
            List<Node> parent = map.getOrDefault(node.val, new ArrayList<>());
            parent.add(new Node(node.left.val, 'L'));
            map.put(node.val, parent);
        }
    }

    static class Node {
        int value;
        char direction;

        public Node() {
        }

        public Node(int value, char direction) {
            this.value = value;
            this.direction = direction;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode() {}
        public TreeNode(int val) { this.val = val; }



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
