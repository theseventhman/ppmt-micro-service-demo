package com.tj.exercise.ppmt.configure.center.demo.common;

import com.tj.exercise.ppmt.configure.center.demo.common.support.PpmtFieldSupport;
import com.tj.exercise.ppmt.configure.center.demo.common.support.PpmtConfigEnvironmentSupport;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: tj
 * @Date: 2023/1/1 22:28
 */
@Slf4j
public class DynamicPropertyFieldListener implements UpdateListener  {
    private PpmtConfigEnvironmentSupport configEnvironmentSupport;
    private PpmtFieldSupport fieldSupport;
    private String fileName;
    private List<DynamicPropertyTarget> targets = new ArrayList<>();
    private String key;

    public DynamicPropertyFieldListener(String fileName, String key, PpmtConfigEnvironmentSupport configEnvironmentSupport, PpmtFieldSupport fieldSupport) {
        this.fileName = fileName;
        this.key = key;
        this.configEnvironmentSupport = configEnvironmentSupport;
        this.fieldSupport = fieldSupport;
    }

    public String getKey() {
        return key;
    }

    public String getFileName() {
        return fileName;
    }

    public DynamicPropertyFieldListener(PpmtConfigEnvironmentSupport configEnvironmentSupport, PpmtFieldSupport fieldSupport) {
        this.configEnvironmentSupport = configEnvironmentSupport;
        this.fieldSupport = fieldSupport;
    }

    @Override
    public void handleEvent(String key, Object newValue, Object oldValue) {
        log.info("---------监听到配置值动态更新，key:{}, newValue :{}, oldValue :{}",key,newValue,oldValue);
        //刷新Environment里的property
        configEnvironmentSupport.refreshEnvironmentProperty(fileName,key,newValue);
        //遍历监听的Field, 进行反射修改
        for(DynamicPropertyTarget target : targets){
            fieldSupport.refreshField(target.getTargetField(),target.getTargetBean(),newValue,target.expression);
        }

    }

    public void addTarget(Field field, Object target, String expression) {
        DynamicPropertyTarget dynamicPropertyTarget = new DynamicPropertyTarget(field,target,expression);
        targets.add(dynamicPropertyTarget);
    }

    public class DynamicPropertyTarget {
        private  Field targetField;
        private Object targetBean;
        private String expression;

        public Field getTargetField() {
            return targetField;
        }

        public Object getTargetBean() {
            return targetBean;
        }

        public String getExpression() {
            return expression;
        }

        public DynamicPropertyTarget(Field targetField, Object targetBean, String expression) {
            this.targetField = targetField;
            this.targetBean = targetBean;
            this.expression = expression;
        }


    }
}
