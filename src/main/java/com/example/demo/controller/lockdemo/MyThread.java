package com.example.demo.controller.lockdemo;


import javax.annotation.Resource;

public class MyThread extends Thread{

    @Resource
    private MyLockController myLockController;

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            new MyThread().start();
        }
    }

    @Override
    public void run() {
        myLockController.process("1");
    }
}
