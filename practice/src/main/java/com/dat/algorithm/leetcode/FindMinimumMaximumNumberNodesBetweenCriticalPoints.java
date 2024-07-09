package com.dat.algorithm.leetcode;

import com.dat.algorithm.leetcode.model.ListNode;

import java.util.Arrays;

public class FindMinimumMaximumNumberNodesBetweenCriticalPoints {
    public static void main(String[] args) {
        FindMinimumMaximumNumberNodesBetweenCriticalPoints findMinimumMaximumNumberNodesBetweenCriticalPoints = new FindMinimumMaximumNumberNodesBetweenCriticalPoints();
        ListNode head = new ListNode(0, new ListNode(2, new ListNode(3, new ListNode(0, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(0, new ListNode(7, new ListNode(8, new ListNode(9, new ListNode(0))))))))))));
        int[] result = findMinimumMaximumNumberNodesBetweenCriticalPoints.nodesBetweenCriticalPoints(head);
        System.out.println("Minimum: " + result[0]);
        System.out.println("Maximum: " + result[1]);
    }

    private int firstPoint;
    private int endPoint;
    private int minimum;
    private int numberOfPoints;
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        firstPoint = -1;
        endPoint = -1;
        minimum = Integer.MAX_VALUE;
        numberOfPoints = 0;
        int[] res = new int[2];
        int previousValue = head.val;
        int index = 1;
        head = head.next;
        while (head != null) {
            int currV = head.val;
            if (head.next == null) {
                break;
            }
            if ((previousValue < currV && currV > head.next.val) || (previousValue > currV && currV < head.next.val)) {
                if (firstPoint == - 1) {
                    firstPoint = index;
                } else {
                    minimum = endPoint == -1 ? Math.min(index - firstPoint, minimum) : Math.min(index - endPoint, minimum);
                    endPoint = index;
                }
                numberOfPoints++;
            }
            previousValue = currV;
            head = head.next;
            index++;
        }
        if (numberOfPoints >= 2) {
            res[0] = minimum;
            res[1] = endPoint - firstPoint;
        } else {
            res[0] = -1;
            res[1] = -1;
        }
        return res;
    }
}
