package com.tj.exercise.ppmt.configure.center.demo.common;

/**
 * @Author: tj
 * @Date: 2022/12/12 20:28
 */
public class RequestUtil implements  Runnable {
    public void run() {
        while (true) {
            System.out.println("模拟调用http请求");
            try {
                Thread.sleep(5 *
                        60 *
                        1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("定时模拟调用http请求出错");
            }
        }
    }
}
