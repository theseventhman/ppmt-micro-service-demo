package com.tj.exercise.ppmt.configure.center.demo.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Author: tj
 * @Date: 2023/1/7 20:58
 */

public class DynamicBeanScanner implements ApplicationRunner, Ordered {
    public static final String PPMT = "com.tj.exercise";
    private List<Object> targetBeans;

    private ApplicationContext applicationContext;

    public DynamicBeanScanner(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<Object> beans = Arrays.stream(applicationContext.getBeanDefinitionNames()).filter(o-> applicationContext.getBean(o).getClass().getName().startsWith(PPMT))
              .map(s-> applicationContext.getBean(s)).collect(Collectors.toList());
        for (Object bean : beans){
            if(bean.getClass().getName().contains("Msg")) {
                Field[] fields = bean.getClass().getFields();
                for(Field field : fields){
                    System.out.println("field的名称为"+field.getName());
                }
            }
        }
        this.targetBeans = beans;
    }

    public  List<Object> getTargetBeans(){
        return this.targetBeans;
    }

    @Override
    public int getOrder() {
        return 9999;
    }
}
