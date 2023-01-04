package com.tj.exercise.ppmt.configure.center.demo.common;

import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;

import java.util.Map;
import java.util.Properties;

/**
 * @Author: tj
 * @Date: 2022/12/22 23:44
 */
public class ConfigLoader {

        private ConfigLoader(){}

    public void load(ConfigurableEnvironment environment) {
        MutablePropertySources propertySources = environment.getPropertySources();
        for(Map.Entry<String, Properties> entry: PpmtKvStore.fileMap.entrySet()){
            PropertiesPropertySource source = new PropertiesPropertySource(entry.getKey(),entry.getValue());
            propertySources.addFirst(source);
        }

    }

    private static class ConfigLoadHelper {
            private static ConfigLoader INSTANCE = new ConfigLoader();
        }

        public static ConfigLoader getInstance(){
            return ConfigLoadHelper.INSTANCE;
        }


    public void loadConfig(Config config){
        Config oldConfig =  PpmtStorageCenter.getInstance().putIfChanged(config);
        PpmtKvStore.put(oldConfig,config);
    }
}
