package com.jfeesoft.fr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.jfeesoft.fr")
public class FastRunnerApplication {
    public static void main(String[] args) {
        SpringApplication.run(FastRunnerApplication.class, args);
    }
}
