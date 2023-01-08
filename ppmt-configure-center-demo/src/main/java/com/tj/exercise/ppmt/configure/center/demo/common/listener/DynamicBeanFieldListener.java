package com.tj.exercise.ppmt.configure.center.demo.common.listener;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: tj
 * @Date: 2023/1/8 21:34
 */
public class DynamicBeanFieldListener implements UpdateListener {
    private List<DynamicFieldTarget> targets = new ArrayList<>();
    private String key;

    public class DynamicFieldTarget{
        private Object targetBean;
        private Field dynamicField;

        public DynamicFieldTarget(Object targetBean, Field dynamicField){
            this.targetBean = targetBean;
            this.dynamicField = dynamicField;
        }
    }

    public void addTarget(Object targetBean, Field targetField){
        DynamicFieldTarget dynamicFieldTarget = new DynamicFieldTarget(targetBean,targetField);
        this.targets.add(dynamicFieldTarget);
    }



    @Override
    public void handleEvent(String key, Object newValue, Object oldValue) {

    }
}
