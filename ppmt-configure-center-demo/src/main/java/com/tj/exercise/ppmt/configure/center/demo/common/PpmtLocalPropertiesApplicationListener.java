package com.tj.exercise.ppmt.configure.center.demo.common;

import com.tj.exercise.ppmt.configure.center.demo.common.util.PropertiesLoaderUtil;
import org.springframework.boot.context.event.ApplicationContextInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;

import java.util.Properties;

/**
 * @Author: tj
 * @Date: 2022/12/30 21:13
 */
public class PpmtLocalPropertiesApplicationListener implements ApplicationListener<ApplicationContextInitializedEvent>, Ordered {
    private static final String PROPERTY_LOCAL_NAME = "ppmt-local";
    private static final String LOCAL_PROPERTIES_FILE_NAME = PROPERTY_LOCAL_NAME+ ".properties";

    private void loadLocalSpecialProperties(MutablePropertySources propertySources){
        Properties properties = PropertiesLoaderUtil.laodFileProperties(LOCAL_PROPERTIES_FILE_NAME);
        if(properties == null || properties.isEmpty()){
            return;
        }
        PropertiesPropertySource source = new PropertiesPropertySource(PROPERTY_LOCAL_NAME,properties);
        propertySources.addFirst(source);
    }

    @Override
    public void onApplicationEvent(ApplicationContextInitializedEvent applicationContextInitializedEvent) {
        MutablePropertySources propertySources =  applicationContextInitializedEvent.getApplicationContext().getEnvironment().getPropertySources();
        loadLocalSpecialProperties(propertySources);
    }

    @Override
    public int getOrder() {
        return HIGHEST_PRECEDENCE + 100;
    }
}
