package com.tj.exercise.ppmt.configure.center.demo;

import com.tj.exercise.ppmt.configure.center.demo.common.RequestUtil;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @Author: tj
 * @Date: 2022/12/12 20:31
 */
@Component
public class ConfigCenterRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        Thread thread = new Thread(new RequestUtil());
        thread.setName("requestUtil");
        thread.setDaemon(true);
        thread.start();
    }
}
