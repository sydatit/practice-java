package com.dat.thread.pool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinPoolExample {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();

        RecursiveTask<Integer> task = new RecursiveTask<>() {
            @Override
            protected Integer compute() {
                int sum = 0;
                for (int i = 1; i <= 10; i++) {
                    sum += i;
                }
                return sum;
            }
        };

        int result = pool.invoke(task);
        System.out.println("Sum: " + result);
    }
}
