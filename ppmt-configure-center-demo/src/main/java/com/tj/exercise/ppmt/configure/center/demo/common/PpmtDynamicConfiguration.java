package com.tj.exercise.ppmt.configure.center.demo.common;

import com.tj.exercise.ppmt.configure.center.demo.ConfigurationPropertiesRefreshHandler;
import com.tj.exercise.ppmt.configure.center.demo.ConfigurationPropertiesRefreshRegistry;
import com.tj.exercise.ppmt.configure.center.demo.PpmtDynamicPropertyRegistery;
import com.tj.exercise.ppmt.configure.center.demo.common.listener.DynamicPropertyFieldListener;
import com.tj.exercise.ppmt.configure.center.demo.common.support.PpmtFieldSupport;
import com.tj.exercise.ppmt.configure.center.demo.common.support.PpmtConfigEnvironmentSupport;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.context.properties.ConfigurationPropertiesBindingPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @Author: tj
 * @Date: 2022/12/27 20:07
 */
@Configuration
public class PpmtDynamicConfiguration {
   @Bean
    public PpmtDynamicPropertyRegistery ppmtDynamicPropertyRegistery(PpmtDynamicProperties ppmtDynamicProperties,ApplicationContext applicationContext, ConfigurableEnvironment environment,
                                                                     PpmtConfigEnvironmentSupport environmentSupport, PpmtFieldSupport ppmtFieldSupport,DynamicBeanScanner dynamicBeanScanner){
        return new PpmtDynamicPropertyRegistery(ppmtDynamicProperties,environment, applicationContext,environmentSupport, ppmtFieldSupport,dynamicBeanScanner);
    }

    @Bean
    public PpmtFieldSupport ppmtFieldSupport(ConfigurableListableBeanFactory beanFactory){
       return new PpmtFieldSupport(beanFactory);
    }

    @Bean
    public PpmtConfigEnvironmentSupport ppmtConfigEnvironmentSupport(ConfigurableEnvironment configurableEnvironment){
       return new PpmtConfigEnvironmentSupport(configurableEnvironment);
    }

    @Bean
    public DynamicPropertyFieldListener dynamicPropertyFieldListener(PpmtConfigEnvironmentSupport configEnvironmentSupport, PpmtFieldSupport fieldSupport){
       return  new DynamicPropertyFieldListener(configEnvironmentSupport,fieldSupport);
    }

    @Bean
    public DynamicBeanScanner dynamicBeanScanner(ApplicationContext applicationContext){
       return new DynamicBeanScanner(applicationContext);
    }

    @Bean
    public ConfigurationPropertiesRefreshFilter configurationPropertiesRefreshFilter(){
       return new ConfigurationPropertiesRefreshFilter();
    }

    @Bean
    public ConfigurationPropertiesRefreshRegistry configurationPropertiesRefreshRegistry(ConfigurationPropertiesBindingPostProcessor propertiesBindingPostProcessor,
                                                  ConfigurationPropertiesRefreshFilter refreshFilter){
       return new ConfigurationPropertiesRefreshRegistry(propertiesBindingPostProcessor,refreshFilter);
    }

    @Bean
    public ConfigurationPropertiesRefreshHandler configurationPropertiesRefreshHandler(){
       return new ConfigurationPropertiesRefreshHandler();
    }
}
