package com.tj.exercise.ppmt.configure.center.demo.common;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: tj
 * @Date: 2022/12/22 16:09
 */
public class PpmtConfig {
    public static List<Config> loadConfigForDownload() {
        System.out.println("模拟配置文件下载");
        List<Config> configs = new ArrayList<>();
        Config newConfig = new Config();
        newConfig.setFileName("application.properties");
        Config springCloudConfig = new Config();
        springCloudConfig.setFileName("springcloud.properties");
        configs.add(newConfig);
        configs.add(springCloudConfig);
        return configs;
    }
}
