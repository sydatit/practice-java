package com.dat.thread.thead_local;

public class ThreadLocalExample {
    public static void main(String[] args) throws InterruptedException {
        MyRunnable sharedRunnableInstance = new MyRunnable();
        Thread thread1 = new Thread(sharedRunnableInstance);
        Thread thread2 = new Thread(sharedRunnableInstance);

        thread1.start();
        thread2.start();

//        thread1.join();
//        thread2.join();
    }
}
