package com.tj.exercise.ppmt.configure.center.demo.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.stereotype.Component;

/**
 * @Author: tj
 * @Date: 2022/12/22 15:09
 */
@Component
public class PpmtDynamicRegistry implements ApplicationContextInitializer<ConfigurableApplicationContext>, EnvironmentPostProcessor {
    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
       PpmtBootStrap.getInstance();
    }

    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        return;
    }
}
