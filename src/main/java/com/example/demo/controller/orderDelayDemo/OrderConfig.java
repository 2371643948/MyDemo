package com.example.demo.controller.orderDelayDemo;

import java.util.concurrent.DelayQueue;

public class OrderConfig {
    public volatile static DelayQueue<OrderDelay> orderDelayDelayQueue = new DelayQueue<>();
}
