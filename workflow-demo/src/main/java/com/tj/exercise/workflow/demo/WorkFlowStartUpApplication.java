package com.tj.exercise.workflow.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: tj
 * @Date: 2022/11/17 0:53
 */
@SpringBootApplication
@EnableDiscoveryClient
public class WorkFlowStartUpApplication {
    public static void main(String[] args) {
        SpringApplication.run(WorkFlowStartUpApplication.class, args);
    }
}
