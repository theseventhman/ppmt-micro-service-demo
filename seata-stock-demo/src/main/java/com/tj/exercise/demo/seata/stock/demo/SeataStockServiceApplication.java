package com.tj.exercise.demo.seata.stock.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: tj
 * @Date: 2023/3/29 10:47
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SeataStockServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(SeataStockServiceApplication.class, args);
    }
}
