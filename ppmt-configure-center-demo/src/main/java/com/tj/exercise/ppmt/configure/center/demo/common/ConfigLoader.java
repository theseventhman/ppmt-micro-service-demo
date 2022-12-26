package com.tj.exercise.ppmt.configure.center.demo.common;

/**
 * @Author: tj
 * @Date: 2022/12/22 23:44
 */
public class ConfigLoader {

        private ConfigLoader(){}

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
