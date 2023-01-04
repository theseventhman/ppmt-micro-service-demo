package com.tj.exercise.ppmt.configure.center.demo.common;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: tj
 * @Date: 2022/12/27 20:03
 */
@Configuration
public class PpmtDynamicProperties implements InitializingBean {
    @Autowired
    private Environment environment;
    private List<String> watchFiles;

    public List<String> getWatchFiles() {
        return watchFiles;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        watchFiles = Arrays.asList(environment.getProperty("watch.file").split(","));
    }
}
