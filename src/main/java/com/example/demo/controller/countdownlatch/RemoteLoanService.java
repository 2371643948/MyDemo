package com.example.demo.controller.countdownlatch;

import java.util.List;

public class RemoteLoanService {
    public MyFutureTask checkAuth(int index, List<Integer> array){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MyFutureTask myFutureTask = new MyFutureTask();
        myFutureTask.setArray(array);
        myFutureTask.setIndex(index);
        myFutureTask.setSum(array.stream().reduce(Integer::sum).get());
        return myFutureTask;
    }
}
