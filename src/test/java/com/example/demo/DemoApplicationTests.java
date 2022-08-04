package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

@SpringBootTest
class DemoApplicationTests {

    @Test
    public void test(){
        ArrayList<String> strings = new ArrayList<>();
        strings.add(new String("1"));
        strings.add(new String("1"));
        Set<String> collect = strings.stream().collect(Collectors.toSet());
        System.out.println(collect);
    }
}
