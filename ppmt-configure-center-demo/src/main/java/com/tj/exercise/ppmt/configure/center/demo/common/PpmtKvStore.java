package com.tj.exercise.ppmt.configure.center.demo.common;

import com.tj.exercise.ppmt.configure.center.demo.common.vo.ConfigInfoVO;
import jdk.management.resource.NotifyingMeter;

import java.net.FileNameMap;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: tj
 * @Date: 2022/12/22 16:13
 */
public class PpmtKvStore {

    private static final ConcurrentHashMap<String,Properties> fileMap;


    public static void put(Config oldConfig, Config newConfig) {
        if(oldConfig !=null){
            //如果有变更，把properties 的名称，变更的属性名称，属性的旧值，属性的新值传入到notifyPropertiesKeyListener方法中
            for(ConfigInfoVO configInfoVO : newConfig.getConfigInfoVOS()) {

                Notify.getInstance().notifyPropertiesKeyListener(oldConfig,configInfoVO.getConfigItem(),configInfoVO.getConfigValue());
            }
        }
        else{
            //会用到Properties的stringPropertyNames
            Properties properties = PropertiesUtil.convertConfigToProperties(newConfig);
            fileMap.put(newConfig.getFileName(),properties);
        }

    }

    private static class Notify {
        private Notify(){

        }

        public void notifyPropertiesKeyListener(Config oldConfig, String configItem, String configValue) {
        }

        private static class NotifyHelper {
            private static Notify INSTANCE = new Notify();
        }

        public static Notify getInstance(){
            return Notify.NotifyHelper.INSTANCE;
        }
    }
}
