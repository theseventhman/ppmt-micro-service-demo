package com.tj.exercise.ppmt.configure.center.demo.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;

import java.util.Map;

/**
 * @Author: tj
 * @Date: 2022/12/31 20:34
 */
@Slf4j
public class PpmtConfigEnvironmentSupport {
    public static final String PPMT_PREFIX = "ppmt_";
    private final ConfigurableEnvironment environment;

    public PpmtConfigEnvironmentSupport(ConfigurableEnvironment environment) {
        this.environment = environment;
    }

    public void refreshEnvironmentProperty(String fileName, String key, Object value){
        MutablePropertySources propertySources = environment.getPropertySources();
        for(PropertySource<?> propertySource : propertySources){
            if(propertySource.getName().equals(PPMT_PREFIX + fileName) && propertySource instanceof PropertiesPropertySource){
                log.info("-------更新Environment Property-----key: {},value :{}",key,value);
                PropertiesPropertySource properties = (PropertiesPropertySource)propertySource;
                Map<String,Object> sourceMap = properties.getSource();
                // PropertiesPropertySource底层为hashTable,  Key和Value都不允许为null
                if(value == null){
                    sourceMap.remove(key);
                }
                else{
                    sourceMap.put(key,value);
                }
                return;
            }
        }
    }
}
