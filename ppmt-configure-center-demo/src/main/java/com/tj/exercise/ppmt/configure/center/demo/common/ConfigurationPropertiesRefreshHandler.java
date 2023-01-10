package com.tj.exercise.ppmt.configure.center.demo.common;

import cn.hutool.core.util.ReflectUtil;
import com.tj.exercise.ppmt.configure.center.demo.DynamicRefreshEventHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.lang.reflect.Method;
import java.util.Map;



/**
 * @Author: tj
 * @Date: 2023/1/10 18:33
 */
@Slf4j
public class ConfigurationPropertiesRefreshHandler implements ApplicationContextAware {

    private static ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        applicationContext = ctx;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public  static void refreshConfigurationProperties(String key, Object oldValue, Object newValue){
        Map<String, DynamicRefreshEventHandler> dynamicRefreshEventHandlerMap = getApplicationContext().getBeansOfType(DynamicRefreshEventHandler.class);
        for(Map.Entry<String,DynamicRefreshEventHandler> entry : dynamicRefreshEventHandlerMap.entrySet()){
            Method method = ReflectUtil.getMethodByName(DynamicRefreshEventHandler.class,"handleRefresh");
            if(method !=null){
                ReflectUtil.invoke(entry.getValue(),method,key,oldValue,newValue);
            }

        }
    }
}
