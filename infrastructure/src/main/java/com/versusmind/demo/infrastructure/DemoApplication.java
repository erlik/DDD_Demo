package com.versusmind.demo.infrastructure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({
        "com.versusmind.demo.core.domain",
        "com.versusmind.demo.core.infra",
        "com.versusmind.demo.domain",
        "com.versusmind.demo.domain.handlers",
        "com.versusmind.demo.infrastructure"})
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
