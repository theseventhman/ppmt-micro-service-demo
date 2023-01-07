package com.tj.exercise.workflow.demo.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: tj
 * @Date: 2023/1/5 22:17
 */
@Configuration
@Data
public class MsgSettingConfig {
    @Value("${my.msgaccount}")
    private  String msgAccount;
}
