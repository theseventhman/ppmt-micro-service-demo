package com.tj.exercise.workflow.demo;

import com.tj.exercise.ppmt.configure.center.demo.ConfigurationPropertiesRefreshHandler;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Author: tj
 * @Date: 2023/1/9 22:45
 */
@Component
public class RefreshHandler implements ApplicationContextAware {
    private static ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        applicationContext = ctx;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }
}
