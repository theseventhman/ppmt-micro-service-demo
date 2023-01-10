package com.tj.exercise.workflow.demo.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: tj
 * @Date: 2023/1/9 21:16
 */
@Configuration
@Data
@ConfigurationProperties(prefix = "my")
public class MyConfigProperties {
    public String msgAccount;
    public String test;
}
