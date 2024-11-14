package com.dat.thread.state.timedwaiting;

public class TimedWaitingState {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new DemoTimeWaitingRunnable());
        t1.start();

        Thread.sleep(1000);
        System.out.println(t1.getState());
    }
}
