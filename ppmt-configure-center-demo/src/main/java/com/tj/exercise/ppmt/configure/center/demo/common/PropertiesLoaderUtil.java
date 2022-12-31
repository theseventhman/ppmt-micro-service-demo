package com.tj.exercise.ppmt.configure.center.demo.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Author: tj
 * @Date: 2022/12/30 21:25
 */
public   class PropertiesLoaderUtil {
    public  static Properties laodFileProperties(String localPropertiesFileName) {
        Properties properties = null;
        InputStream stream = PropertiesLoaderUtil.class.getClassLoader().getResourceAsStream(localPropertiesFileName);
        try {
            properties.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return properties;
    }
}
