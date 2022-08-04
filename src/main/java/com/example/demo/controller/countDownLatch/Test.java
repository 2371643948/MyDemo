package com.example.demo.controller.countDownLatch;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.*;

public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> strings = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            strings.add(new Random().nextInt(10));
        }
        System.out.println(strings);
        test(strings);
    }

    private static void test(ArrayList<Integer> strings) {
        int init = 3;
        int max = 3 * 4;
        int index = 0;
        int size = 5;
        int fori = strings.size() / size;
        CountDownLatch latch = new CountDownLatch(100);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(init, max, 1, TimeUnit.MINUTES, new LinkedBlockingDeque<>(), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r);
            }
        });

        ArrayList<CheckFutureTask> futureTasks = new ArrayList<>();
        for (int i = 0; i < fori; i++) {
            CheckFutureTask checkFutureTask = new CheckFutureTask(new RemoteLoanThread(index, size, strings), latch);
            futureTasks.add(checkFutureTask);
            index+=size;
        }
        for (FutureTask futureTask : futureTasks) {
            threadPoolExecutor.execute(futureTask);
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (CheckFutureTask futureTask : futureTasks) {
            try {
                MyFutureTask myFutureTask = futureTask.get();
                System.out.println(myFutureTask);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        threadPoolExecutor.shutdownNow();
    }
}
