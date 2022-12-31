package com.tj.exercise.ppmt.configure.center.demo;

/**
 * @Author: tj
 * @Date: 2022/12/31 19:28
 */
public interface DynamicRefreshEventHandler {
    String getListenKey();
    boolean isPrefixMatch();
    void handleRefresh(String key, String newValue, String oldValue);
}
