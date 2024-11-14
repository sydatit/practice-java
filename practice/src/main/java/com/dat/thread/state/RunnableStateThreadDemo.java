package com.dat.thread.state;

public class RunnableStateThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new NewState();
        Thread thread = new Thread(runnable);
        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());
        thread.join();
        System.out.println(thread.getState());
    }
}
