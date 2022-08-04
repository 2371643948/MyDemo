package com.example.demo.controller.orderDelayDemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;

//开关
//@Component
@Order(value = 1)
public class MyTestThread implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("新线程延时任务正在运行");
        // 执行具体业务功能
        while (true){
            System.out.println("运行中");
            long start = System.currentTimeMillis();

            try {
                OrderConfig.orderDelayDelayQueue.take().print();

                System.out.println("After " +

                        (System.currentTimeMillis() - start) + " MilliSeconds");

                System.out.println(OrderConfig.orderDelayDelayQueue.toString());

            } catch (InterruptedException e) {

                // TODO Auto-generated catch block

                e.printStackTrace();

            }
        }
    }
}