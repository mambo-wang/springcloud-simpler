package com.h3c.sidecar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;

@SpringBootApplication
@EnableSidecar
public class SideCarApplication {
    public static void main(String[] args) {
        SpringApplication.run(SideCarApplication.class, args);
    }
}
