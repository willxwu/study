package com.example.study.vip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class StudyVipApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyVipApplication.class, args);
    }

}
