package com.example.demo.controller.orderDelayDemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PayController {

    @GetMapping("/test")
    public void pay(){
        OrderDelay orderDelay = new OrderDelay(String.valueOf(Math.random()),10000000000L);
        OrderConfig.orderDelayDelayQueue.put(orderDelay);
    }
}
