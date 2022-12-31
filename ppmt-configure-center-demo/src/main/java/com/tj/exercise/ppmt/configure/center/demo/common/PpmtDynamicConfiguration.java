package com.tj.exercise.ppmt.configure.center.demo.common;

import com.tj.exercise.ppmt.configure.center.demo.PpmtDynamicPropertyRegistery;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: tj
 * @Date: 2022/12/27 20:07
 */
@Configuration
public class PpmtDynamicConfiguration {
   @Bean
    public PpmtDynamicPropertyRegistery configCenterRunner(PpmtDynamicProperties ppmtDynamicProperties){
        return new PpmtDynamicPropertyRegistery(ppmtDynamicProperties);
    }
}
