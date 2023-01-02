package com.tj.exercise.ppmt.configure.center.demo.common.support;

import cn.hutool.core.util.ReflectUtil;
import com.sun.el.util.ReflectionUtil;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.DependencyDescriptor;

import java.lang.reflect.Field;
import java.util.Collections;

/**
 * @Author: tj
 * @Date: 2022/12/31 20:56
 */
public class PpmtFieldSupport {
    private ConfigurableListableBeanFactory beanFactory;

    public PpmtFieldSupport(ConfigurableListableBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public void refreshField(Field field, Object target, Object newValue, String expression){
        DependencyDescriptor desc = new DependencyDescriptor(field,true);
        desc.setContainingClass(target.getClass());
        Object object = beanFactory.resolveDependency(desc,null, Collections.emptySet(),beanFactory.getTypeConverter());
        ReflectUtil.setFieldValue(target,field,object);
    }
}
