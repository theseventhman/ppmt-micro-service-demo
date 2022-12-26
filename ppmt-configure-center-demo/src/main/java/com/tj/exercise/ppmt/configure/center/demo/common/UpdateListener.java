package com.tj.exercise.ppmt.configure.center.demo.common;

/**
 * @Author: tj
 * @Date: 2022/12/22 16:58
 */
public class UpdateListener {
    public void handleEvent(String configItem) {
        System.out.println("监控environment中的更改");
        System.out.println("监控Bean中的对应Field的更改");
    }
}
