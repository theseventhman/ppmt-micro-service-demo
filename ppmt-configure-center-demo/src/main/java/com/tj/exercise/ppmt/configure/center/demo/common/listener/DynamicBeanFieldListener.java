package com.tj.exercise.ppmt.configure.center.demo.common.listener;

import com.tj.exercise.ppmt.configure.center.demo.common.support.PpmtFieldSupport;

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
    private PpmtFieldSupport fieldSupport;

    public DynamicBeanFieldListener(String key, PpmtFieldSupport fieldSupport) {
        this.key = key;
        this.fieldSupport = fieldSupport;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public class DynamicFieldTarget{
        private Object targetBean;
        private Field targetField;

        public Object getTargetBean() {
            return targetBean;
        }

        public Field getTargetField() {
            return targetField;
        }

        public DynamicFieldTarget(Object targetBean, Field targetField){
            this.targetBean = targetBean;
            this.targetField = targetField;
        }
    }

    public void addTarget(Object targetBean, Field targetField){
        DynamicFieldTarget dynamicFieldTarget = new DynamicFieldTarget(targetBean,targetField);
        this.targets.add(dynamicFieldTarget);
    }



    @Override
    public void handleEvent(String key, Object newValue, Object oldValue) {
      //遍历监听的Field, 进行反射修改
        for(DynamicFieldTarget target : targets){
            fieldSupport.refreshField(target.getTargetField(),target.getTargetBean(),newValue,null);
        }
    }
}
