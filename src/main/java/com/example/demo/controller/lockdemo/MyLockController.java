package com.example.demo.controller.lockdemo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@RestController
@Component
@Slf4j
public class MyLockController {

    @Resource
    private SynchronizedByKey synchronizedByKey;

    @GetMapping("/testLock")
    public void process(String orderId){
        synchronizedByKey.exec(orderId,()->{
            log.info(orderId+"开始");
            service();
            log.info(orderId+"结束");
        });
    }

    private void service() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test(){
        ArrayList<String> strings = new ArrayList<>();
        strings.add(new String("1"));
        strings.add(new String("1"));
        System.out.println(strings);
        Set<String> collect = strings.stream().collect(Collectors.toSet());
        List<String> collect1 = collect.stream().distinct().collect(Collectors.toList());
        System.out.println(collect1);
        System.out.println(collect);
    }
}
