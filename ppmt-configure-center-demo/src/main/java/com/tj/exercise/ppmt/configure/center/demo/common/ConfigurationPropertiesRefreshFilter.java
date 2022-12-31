package com.tj.exercise.ppmt.configure.center.demo.common;

/**
 * @Author: tj
 * @Date: 2022/12/31 19:15
 */
public class ConfigurationPropertiesRefreshFilter {
    public boolean canRefresh(Object bean) {
        return  bean.toString().startsWith("xx");
    }
}
