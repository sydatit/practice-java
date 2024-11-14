package com.dat.algorithm.leetcode;

import com.dat.algorithm.leetcode.model.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CreateBinaryTreeFromDescriptions {
    public static void main(String[] args) {
        CreateBinaryTreeFromDescriptions createBinaryTreeFromDescriptions = new CreateBinaryTreeFromDescriptions();
        int[][] descriptions = new int[][]{{1, 2, 0}, {1, 3, 1}, {2, 4, 0}, {2, 5, 1}};
        TreeNode root = createBinaryTreeFromDescriptions.createBinaryTree(descriptions);
        System.out.println(root);
    }

    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Map<Integer, Integer> traces = new HashMap<>();
        int childValue = -1;
        for (int[] description :descriptions) {
            int parent = description[0];
            int child = description[1];
            boolean isLeft = description[2] == 1;
            TreeNode nodeP = map.getOrDefault(parent, new TreeNode(parent));
            TreeNode nodeC = map.getOrDefault(child, new TreeNode(child));
            if (isLeft) {
                nodeP.setLeft(nodeC);
            } else {
                nodeP.setRight(nodeC);
            }
            traces.put(child, parent);
            if (childValue == -1) {
                childValue = child;
            }
            map.put(parent, nodeP);
            map.put(child, nodeC);
        }
        while (traces.get(childValue) != null) {
            childValue = traces.get(childValue);
        }
        return map.get(childValue);
    }
}
