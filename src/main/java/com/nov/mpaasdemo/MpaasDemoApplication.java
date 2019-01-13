package com.nov.mpaasdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.definesys.mpaas","com.nov.mpaasdemo"})
public class MpaasDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MpaasDemoApplication.class, args);
    }

}

