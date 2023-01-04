package com.tj.exercise.ppmt.configure.center.demo.common;

import com.tj.exercise.ppmt.configure.center.demo.common.util.PropertiesLoaderUtil;
import com.tj.exercise.ppmt.configure.center.demo.common.util.PropertiesUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: tj
 * @Date: 2022/12/22 16:13
 */
public class PpmtKvStore {

    public static final ConcurrentHashMap<String,Properties> fileMap = new ConcurrentHashMap<>();


    public static void put(Config oldConfig, Config newConfig) {
        if(oldConfig !=null){
            //如果有变更，把properties 的名称，变更的属性名称，属性的旧值，属性的新值传入到notifyPropertiesKeyListener方法中
               Properties properties = PropertiesLoaderUtil.laodFileProperties(oldConfig.getConfigFileName());
            Properties newProperties = PropertiesLoaderUtil.laodFileProperties(oldConfig.getConfigFileName());

            for (String  key : properties.stringPropertyNames()) {
                     Object oldValue = properties.getProperty(key);
                     Object newValue =  newProperties.getProperty(key);
                    Notify.getInstance().notifyPropertiesKeyListener(oldConfig.getConfigFileName(), key, oldValue,newValue); }

        }
        else{
            //会用到Properties的stringPropertyNames
            Properties properties = PropertiesUtil.convertConfigToProperties(newConfig);
            fileMap.put(newConfig.getConfigFileName(),properties);
        }

    }

    public static class Notify {
        private ConcurrentHashMap<String, List<UpdateListener>> listenerMap;
        private Notify(){
           listenerMap = new ConcurrentHashMap<>();
        }


        public void addPropertiesListener(String fileName, String key, DynamicPropertyFieldListener dynamicPropertyFieldListener) {
            String listenerKey = generateListenKey(fileName,key);
            if(listenerMap.containsKey(listenerKey)){
                listenerMap.computeIfPresent(listenerKey,(k,v) ->{
                    v.add(dynamicPropertyFieldListener);
                        return v;
                });
            }
            else{
                List<UpdateListener> listeners = new ArrayList<>();
                listeners.add(dynamicPropertyFieldListener);
                listenerMap.put(listenerKey,listeners);
            }
        }

        private String generateListenKey(String fileName, String key) {
            String listenKey = fileName+key;
            return listenKey;
        }

        public void notifyPropertiesKeyListener(String configFileName, String key, Object oldValue, Object newValue) {
        }

        private static class NotifyHelper {
            private static Notify INSTANCE = new Notify();
        }

        public static Notify getInstance(){
            return Notify.NotifyHelper.INSTANCE;
        }
    }
}
