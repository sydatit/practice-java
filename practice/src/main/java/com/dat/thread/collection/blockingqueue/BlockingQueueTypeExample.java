package com.dat.thread.collection.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueTypeExample {
    public static void main(String[] args) {
        BlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(10);

        Thread producer = new Thread(() -> {
            for (int i = 0; i < 18; i++) {
                try {
                    arrayBlockingQueue.put(i);
                    System.out.println("+ Put: " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        producer.start();
        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 8; i++) {
                try {
                    System.out.println("------ Take: " + arrayBlockingQueue.take());
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        consumer.start();
    }
}
