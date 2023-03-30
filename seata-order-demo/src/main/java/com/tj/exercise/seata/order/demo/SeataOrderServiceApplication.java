package com.tj.exercise.seata.order.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: tj
 * @Date: 2023/3/29 10:19
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class SeataOrderServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(SeataOrderServiceApplication.class, args);
    }
}
