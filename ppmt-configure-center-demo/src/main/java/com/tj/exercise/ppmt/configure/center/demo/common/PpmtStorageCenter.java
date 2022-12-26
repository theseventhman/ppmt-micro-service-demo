package com.tj.exercise.ppmt.configure.center.demo.common;

import org.apache.catalina.Store;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: tj
 * @Date: 2022/12/22 16:12
 */
public class PpmtStorageCenter {
    private final static  ConcurrentHashMap<String,Config> store = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String,Object> fileMap = new ConcurrentHashMap<>();

    private PpmtStorageCenter(){

    }

    private static class PpmtStorageCenterHelper {
        private static PpmtStorageCenter INSTANCE = new PpmtStorageCenter();
    }

    public static PpmtStorageCenter getInstance(){
        return PpmtStorageCenter.PpmtStorageCenterHelper.INSTANCE;
    }



    public  Config putIfChanged(Config config) {
        Config oldConfig = null;
        if(store.get(config.getFileName()) == null){
            store.put(config.getFileName(),config);
            oldConfig = store.get(config.getFileName());
        }
        return oldConfig;

    }
}
