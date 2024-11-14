package com.dat.algorithm.leetcode;

public class CountNumberTeams {
    public static void main(String[] args) {

    }
    private int sum;
    public int numTeams(int[] rating) {
        int[] numOfLessNum = new int[100001];
        int sum = 0;
        countIncrementTeams(numOfLessNum, rating);

        return sum;
    }

    private void countIncrementTeams(int[] numOfLessNum, int[] rating) {
        Node root = new Node(rating[0]);
        for (int i = 1; i < rating.length; i++) {
            int currentLessNum = 0;
            Node temp = root;
            Node previous = null;
            while (temp != null && rating[i] > temp.value) {
                currentLessNum++;
                previous = temp;
                temp = temp.next;
            }
            
        }
    }

    class Node {
        int value;
        Node next;

        public Node() {
        }

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
