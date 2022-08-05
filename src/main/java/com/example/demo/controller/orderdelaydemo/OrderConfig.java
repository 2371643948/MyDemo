package com.example.demo.controller.orderdelaydemo;

import java.util.concurrent.DelayQueue;

public class OrderConfig {
    public volatile static DelayQueue<OrderDelay> orderDelayDelayQueue = new DelayQueue<>();
}
