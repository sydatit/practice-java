package com.dat.thread.state;

public class NewStateThreadDemo {
    public static void main(String[] args) {
        Runnable runnable = new NewState();
        Thread thread = new Thread(runnable);
        System.out.println(thread.getState());
    }
}
