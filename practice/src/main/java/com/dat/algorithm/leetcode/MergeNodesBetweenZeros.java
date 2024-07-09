package com.dat.algorithm.leetcode;

import com.dat.algorithm.leetcode.model.ListNode;

public class MergeNodesBetweenZeros {
    public static void main(String[] args) {
        MergeNodesBetweenZeros mergeNodesBetweenZeros = new MergeNodesBetweenZeros();
        ListNode head = new ListNode(0, new ListNode(2, new ListNode(3, new ListNode(0, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(0, new ListNode(7, new ListNode(8, new ListNode(9, new ListNode(0))))))))))));
        ListNode result = mergeNodesBetweenZeros.mergeNodes(head);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
    public ListNode mergeNodes(ListNode head) {
        head = head.next;
        ListNode temp = head;
        while (temp != null) {
            int sum = temp.val;
            ListNode next = temp.next;

            while (next.val != 0) {
                sum += next.val;
                next = next.next;
            }
            if (sum != 0) {
                temp.val = sum;
            }
            next = next.next;
            temp.next = next;
            temp = next;
        }
        return head;
    }


}
