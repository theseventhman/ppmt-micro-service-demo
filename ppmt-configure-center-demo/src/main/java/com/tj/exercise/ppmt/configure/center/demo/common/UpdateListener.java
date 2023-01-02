package com.tj.exercise.ppmt.configure.center.demo.common;

/**
 * @Author: tj
 * @Date: 2022/12/22 16:58
 */
public interface UpdateListener {
    public void handleEvent(String key,Object newValue, Object oldValue);
}
