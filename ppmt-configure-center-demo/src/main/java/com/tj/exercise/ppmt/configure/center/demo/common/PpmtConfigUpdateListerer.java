package com.tj.exercise.ppmt.configure.center.demo.common;

/**
 * @Author: tj
 * @Date: 2022/12/22 16:56
 */
public class PpmtConfigUpdateListerer {
    public static void addListener(Config oldConfig, String configItem, String configValue) {
        for(UpdateListener listener : oldConfig.getListeners()){
            listener.handleEvent(configItem);
        }
    }
}
