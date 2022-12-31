package com.tj.exercise.ppmt.configure.center.demo;

import com.tj.exercise.ppmt.configure.center.demo.common.PpmtDynamicProperties;
import com.tj.exercise.ppmt.configure.center.demo.common.RequestUtil;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * @Author: tj
 * @Date: 2022/12/12 20:31
 */

public class PpmtDynamicPropertyRegistery implements InitializingBean, ApplicationRunner, Ordered {
    private PpmtDynamicProperties ppmtDynamicProperties;

    public PpmtDynamicPropertyRegistery(PpmtDynamicProperties ppmtDynamicProperties) {
        this.ppmtDynamicProperties = ppmtDynamicProperties;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Thread thread = new Thread(new RequestUtil());
        thread.setName("requestUtil");
        thread.setDaemon(true);
        thread.start();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("调用到了afterPropertiesSet方法");
    }

    @Override
    public int getOrder() {
        return 10000;
    }
}
