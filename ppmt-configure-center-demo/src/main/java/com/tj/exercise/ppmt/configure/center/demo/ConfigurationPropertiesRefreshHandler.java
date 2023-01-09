package com.tj.exercise.ppmt.configure.center.demo;

import cn.hutool.core.util.ReflectUtil;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * @Author: tj
 * @Date: 2023/1/9 21:30
 */

public class ConfigurationPropertiesRefreshHandler implements ApplicationContextAware {
    private static ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        ConfigurationPropertiesRefreshHandler.applicationContext = ctx;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }
    public static void refreshConfigurationProperties(String key, Object oldValue, Object newValue){
        Map<String,DynamicRefreshEventHandler> dynamicRefreshEventHandlerMap = getApplicationContext().getBeansOfType(DynamicRefreshEventHandler.class);
        for(Map.Entry<String,DynamicRefreshEventHandler> entry : dynamicRefreshEventHandlerMap.entrySet()){
            Method method = ReflectUtil.getMethodByName(DynamicRefreshEventHandler.class,"handleRefresh");
            if(method !=null){
                ReflectUtil.invoke(entry.getValue(),method,key,oldValue,newValue);
            }

        }
    }
}
