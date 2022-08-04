package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi
@Slf4j
public class DemoApplication {

    public static void main(String[] args) {
        log.info("=================springboot start=================");
        SpringApplication.run(DemoApplication.class, args);
    }

}
