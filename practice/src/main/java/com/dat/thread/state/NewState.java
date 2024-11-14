package com.dat.thread.state;

public class NewState implements Runnable{
    @Override
    public void run() {
        System.out.println("Thread is running");
    }
}
