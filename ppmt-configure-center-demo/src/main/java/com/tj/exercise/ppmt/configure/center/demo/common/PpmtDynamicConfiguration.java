package com.tj.exercise.ppmt.configure.center.demo.common;

import com.tj.exercise.ppmt.configure.center.demo.PpmtDynamicPropertyRegistery;
import com.tj.exercise.ppmt.configure.center.demo.common.support.PpmtFieldSupport;
import com.tj.exercise.ppmt.configure.center.demo.common.support.PpmtConfigEnvironmentSupport;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
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
    public PpmtDynamicPropertyRegistery ppmtDynamicPropertyRegistery(PpmtDynamicProperties ppmtDynamicProperties,ConfigurableEnvironment environment,
                                                                     PpmtConfigEnvironmentSupport environmentSupport, PpmtFieldSupport ppmtFieldSupport){
        return new PpmtDynamicPropertyRegistery(ppmtDynamicProperties,environment, environmentSupport, ppmtFieldSupport);
    }

    @Bean
    public PpmtFieldSupport ppmtFieldSupport(ConfigurableListableBeanFactory beanFactory){
       return new PpmtFieldSupport(beanFactory);
    }

    @Bean
    public PpmtConfigEnvironmentSupport ppmtConfigEnvironmentSupport(ConfigurableEnvironment configurableEnvironment){
       return new PpmtConfigEnvironmentSupport(configurableEnvironment);
    }
}
