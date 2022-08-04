package com.example.demo.controller.countDownLatch;

import java.util.List;
import java.util.concurrent.Callable;

public class RemoteLoanThread implements Callable<MyFutureTask> {
    private int index;
    private int size;
    private List<Integer> array;

    public RemoteLoanThread(int index, int size, List<Integer> array) {
        this.index = index;
        this.size = size;
        this.array = array;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<Integer> getArray() {
        return array;
    }

    public void setArray(List<Integer> array) {
        this.array = array;
    }

    @Override
    public MyFutureTask call() throws Exception {
        return new RemoteLoanService().checkAuth(index,array.subList(index,index+size));
    }
}
