package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.Benchmark;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

@SpringBootTest
@Slf4j
public class DemoApplicationTests {

    @Test
    public void test(){
        ArrayList<String> strings = new ArrayList<>();
        strings.add(new String("1"));
        strings.add(new String("1"));
        Set<String> collect = strings.stream().collect(Collectors.toSet());
        System.out.println(collect);
    }

    @Test
    @Benchmark
    public void test01() {
        log.info("{}", StringUtils.EMPTY);
    }
}
