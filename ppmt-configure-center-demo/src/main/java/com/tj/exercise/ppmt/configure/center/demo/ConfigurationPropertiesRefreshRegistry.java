package com.tj.exercise.ppmt.configure.center.demo;

import com.tj.exercise.ppmt.configure.center.demo.common.ConfigurationPropertiesRefreshFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesBindingPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.Ordered;

import java.util.Map;

/**
 * @Author: tj
 * @Date: 2022/12/30 22:22
 */
@Slf4j
public class ConfigurationPropertiesRefreshRegistry implements ApplicationRunner, ApplicationContextAware, Ordered {
    private ApplicationContext applicationContext;
    private ConfigurationPropertiesRefreshFilter refreshFilter;
    private final ConfigurationPropertiesBindingPostProcessor propertiesBindingPostProcessor;

    public ConfigurationPropertiesRefreshRegistry(ConfigurationPropertiesBindingPostProcessor propertiesBindingPostProcessor,
                                                  ConfigurationPropertiesRefreshFilter refreshFilter){
        this.propertiesBindingPostProcessor = propertiesBindingPostProcessor;
        this.refreshFilter = refreshFilter;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        GenericApplicationContext context;
        if(applicationContext instanceof GenericApplicationContext){
            context = (GenericApplicationContext)applicationContext;
        } else{
            return;
        }
        //扫描@ConfigurationProperties的bean
        Map<String,Object> propertiesBeanMap = applicationContext.getBeansWithAnnotation(ConfigurationProperties.class);
        for(Map.Entry<String,Object> entry : propertiesBeanMap.entrySet()){
            String beanName = entry.getKey();
            Object bean = entry.getValue();
            if(!refreshFilter.canRefresh(bean)){
                continue;
            }
            //获取ConfigurationProperties的prefix
            ConfigurationProperties annotation = context.findAnnotationOnBean(beanName,ConfigurationProperties.class);
            String prefix = annotation.prefix();
            context.registerBean(beanName +".refresher",
                    DynamicRefreshEventHandler.class,() -> new DynamicRefreshEventHandler(){
                       @Override
                        public String getListenKey(){
                            return prefix;
                        }

                        @Override
                        public boolean isPrefixMatch() {
                            return true;
                        }

                        @Override
                        public void handleRefresh(String key, String newValue, String oldValue) {
                           propertiesBindingPostProcessor.postProcessBeforeInitialization(bean,beanName);
                        }

                    });
            log.info("注册@ConfigurationProperties ->{},动态刷新成功",beanName);

        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
       this.applicationContext = applicationContext;
    }

    @Override
    public int getOrder() {
        return 10000+50;
    }
}
