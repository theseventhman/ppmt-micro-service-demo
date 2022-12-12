package com.tj.exercise.ppmt.configure.center.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: tj
 * @Date: 2022/12/12 20:33
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConfigureCenterDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigureCenterDemoApplication.class, args);
    }
}
