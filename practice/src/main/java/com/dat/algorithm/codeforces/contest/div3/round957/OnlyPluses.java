package com.dat.algorithm.codeforces.contest.div3.round957;

import java.util.PriorityQueue;
import java.util.Scanner;

public class OnlyPluses {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-->0) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            int numberOfPluses = 5;
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            pq.add(a);
            pq.add(b);
            pq.add(c);
            while (numberOfPluses > 0 && !pq.isEmpty()) {
                int min = pq.poll();
                min++;
                numberOfPluses--;
                pq.add(min);
            }
            int result = 1;
            while (!pq.isEmpty()) {
                result *= pq.poll();
            }
            System.out.println(result);
        }
    }
}
