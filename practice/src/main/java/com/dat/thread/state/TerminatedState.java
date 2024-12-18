package com.dat.thread.state;

public class TerminatedState implements Runnable {
    @Override
    public void run() {

    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new TerminatedState());
        t1.start();

        Thread.sleep(1000);

        System.out.println(t1.getState());
    }
}
