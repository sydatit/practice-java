//package com.dat.algorithm.codeforces.contest.div3.round962.A;

import java.util.Scanner;

public class Legs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t --> 0) {
            int legs = scanner.nextInt();
            int res = 0;
            res += legs/4;
            legs = legs % 4;
            res += legs > 0 ? 1 : 0;
            System.out.println(res);
        }
    }
}
