package com.example.demo.controller.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author panjch@mochasoft.com.cn
 * @create: 2022/7/26 14:34
 */

@Slf4j
@RequestMapping("/kafka")
public class MyKafkaDemoController {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @GetMapping("/normal")
    public void normal(String message) {
        log.info(message);
        kafkaTemplate.send("topic1", message).addCallback(success -> log.info("成功"), failure -> log.info("失败"));
    }

    @KafkaListener(topics = {"topic1"})
    public void onMessage(final ConsumerRecord<String, String> consumerRecord) {
        log.info("消息：{}", consumerRecord.value());
    }
}
