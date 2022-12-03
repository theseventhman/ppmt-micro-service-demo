package com.tj.exercise.ppmt.core.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: tj
 * @Date: 2022/11/20 22:17
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class PpmtCoreStartUpApplication {
    public static void main(String[] args) {
        SpringApplication.run(PpmtCoreStartUpApplication.class, args);
    }
}
