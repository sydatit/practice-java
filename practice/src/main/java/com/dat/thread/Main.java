package com.dat.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // Có 100 request tới cùng lúc

        for (int i = 0; i < 100; i++) {
            int finalI = i;
            long begin = System.currentTimeMillis();
            Future<?> future = executor.submit(() -> {
                System.out.println("Thread: " + Thread.currentThread().getName() + " solving task: " + finalI);

                // Giả lập thời gian xử lý task
                int random = 0;
                try {
                    // random time from 0 to 3 seconds
                    random = (int) (Math.random() * 3000);
                    Thread.sleep(random);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                return random;
            }); // Trả về Future

            long end = System.currentTimeMillis();
            System.out.println("is done: " + future.isDone());
//            future.get(); // Đợi task kết thúc

//            System.out.println("Time to solve task " + finalI + ": " + (end - begin) + "ms and result: " + future.get());
        }
        executor.shutdown(); // Không cho threadpool nhận thêm nhiệm vụ nào nữa

        while (!executor.isTerminated()) {
            // Chờ xử lý hết các request còn chờ trong Queue ...
        }
    }
}
