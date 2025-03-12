package com.example.study.id;

import com.sankuai.inf.leaf.plugin.annotation.EnableLeafServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableLeafServer
@SpringBootApplication
public class StudyIdApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyIdApplication.class, args);
    }

}
