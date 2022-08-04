package com.example.demo.controller.countDownLatch;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.FutureTask;

public class CheckFutureTask extends FutureTask<MyFutureTask> {
    private volatile CountDownLatch latch;

    public CheckFutureTask(Callable<MyFutureTask> callable, CountDownLatch latch) {
        super(callable);
        this.latch = latch;
    }

    @Override
    protected void done() {
        latch.countDown();
    }
}
