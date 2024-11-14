package com.dat.thread.state;

import com.dat.algorithm.leetcode.SortArray;

public class BlockedStateDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new DemoBlockedRunnable(), "Thread-1");
        Thread thread2 = new Thread(new DemoBlockedRunnable(), "Thread-2");
        thread1.start();
        thread2.start();

        Thread.sleep(1000);

        System.out.println(thread2.getState());
        System.exit(0);
    }

    static class DemoBlockedRunnable implements Runnable {
        @Override
        public void run() {
            synchronized (BlockedStateDemo.class) {
                System.out.println("Thread " + Thread.currentThread().getName() + " is running");
                while (true) {
                    // do nothing
                }
            }
        }
    }
}
