package com.tj.exercise.ppmt.configure.center.demo.common;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: tj
 * @Date: 2022/12/27 20:03
 */
@Configuration
public class PpmtDynamicProperties implements InitializingBean {
    private String watchFiles;

    public String getWatchFiles() {
        return watchFiles;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        watchFiles = "justfortest";
    }
}
