package com.tj.exercise.ppmt.configure.center.demo.common.util;

import com.alibaba.nacos.common.utils.IoUtils;
import com.fasterxml.jackson.core.util.BufferRecycler;
import com.tj.exercise.ppmt.configure.center.demo.common.Config;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.Properties;

/**
 * @Author: tj
 * @Date: 2022/12/25 23:27
 */
public class PropertiesUtil {
    public static Properties convertConfigToProperties(Config newConfig) {
        Properties p =null;
        BufferedReader bf = null;
        try {
          //  p.load(new StringReader(newConfig.getValue()));
            p = new Properties();
            bf = new BufferedReader(new InputStreamReader(IOUtils.toInputStream(newConfig.getValue()),"UTF-8"));
            p.load(bf);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            IoUtils.closeQuietly(bf);
        }
        return p;
    }
}
