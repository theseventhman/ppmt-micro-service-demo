package com.tj.exercise.ppmt.configure.center.demo;

import cn.hutool.core.util.StrUtil;
import com.tj.exercise.ppmt.configure.center.demo.common.DynamicPropertyFieldListener;
import com.tj.exercise.ppmt.configure.center.demo.common.PpmtBootStrap;
import com.tj.exercise.ppmt.configure.center.demo.common.PpmtDynamicProperties;
import com.tj.exercise.ppmt.configure.center.demo.common.PpmtKvStore;
import com.tj.exercise.ppmt.configure.center.demo.common.support.PpmtFieldSupport;
import com.tj.exercise.ppmt.configure.center.demo.common.support.PpmtConfigEnvironmentSupport;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.Ordered;
import org.springframework.core.env.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @Author: tj
 * @Date: 2022/12/12 20:31
 */
@Slf4j
public class PpmtDynamicPropertyRegistery implements InitializingBean, ApplicationRunner, Ordered {
    private PpmtDynamicProperties ppmtDynamicProperties;
    private List<String> watcheKeys = new ArrayList<>();
    private List<String> fileNames = new ArrayList<>();
    private ConfigurableEnvironment environment;
    private List<DynamicPropertyFieldListener> listeners = new ArrayList<>();
    private PpmtConfigEnvironmentSupport configEnvironmentSupport;
    private PpmtFieldSupport fieldSupport;

    public PpmtDynamicPropertyRegistery(PpmtDynamicProperties ppmtDynamicProperties, ConfigurableEnvironment environment, PpmtConfigEnvironmentSupport environmentSupport,
                                        PpmtFieldSupport fieldSupport) {
        this.ppmtDynamicProperties = ppmtDynamicProperties;
        this.environment = environment;
        this.configEnvironmentSupport = environmentSupport;
        this.fieldSupport = fieldSupport;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //注册剩下的watchKeys
        //如果有指定的watchKeys,只根据watchKeys扫描，如果没有指定，那就扫描默认FileName里的property
        if(watcheKeys.isEmpty()){
            registerFileProperties();
        }
        else{
            for(String key : watcheKeys){
                addDynamicPropertyListen(key);
            }
        }
        log.info("-----------绑定Ppmt动态更新任务开始, 监听KEY总数为{}---------",this.listeners.size());
        for(DynamicPropertyFieldListener listener : this.listeners){
            log.info("----------Ppmt动态配置Key :{}----------",listener.getKey());
            //添加变更监听
            PpmtKvStore.Notify.getInstance().addPropertiesListener(listener.getFileName(),listener.getKey(),listener);
        }
        PpmtBootStrap.getInstance().init();


    }

    private void registerFileProperties() {
        for(String fileName : fileNames){
            String sourceFileName = PpmtConfigEnvironmentSupport.SOURCE_NAME_PREFIX + fileName;
            MutablePropertySources sources = environment.getPropertySources();
            Optional<PropertySource<?>> propertySource = sources.stream()
                    .filter(s -> sourceFileName.equals(s.getName())).findAny();
            if(propertySource.isPresent() && propertySource.get() instanceof PropertiesPropertySource){
                PropertiesPropertySource source = (PropertiesPropertySource) propertySource.get();
                for(String key : source.getSource().keySet()){
                    addDynamicPropertyListen(key);
                }
            }
        }
    }

    private void addDynamicPropertyListen(String key) {
        addDynamicPropertyListen(null,null,null,key);
    }
    
    private void  addDynamicPropertyListen(Field field, Object target, String expression, String key){
        for(String fileName : fileNames){
            DynamicPropertyFieldListener listener = getListener(fileName,key);
            if(field !=null && target !=null){
                listener.addTarget(field,target,expression);
            }
        }
    }

    private DynamicPropertyFieldListener getListener(String fileName, String key) {
        for(DynamicPropertyFieldListener listener : this.listeners) {
            if (StrUtil.equals(fileName, listener.getFileName()) && StrUtil.equals(key, listener.getKey())) {
                return listener;
            }
        }
            //没找到的话，就新建一个listener并返回
            DynamicPropertyFieldListener listener = new DynamicPropertyFieldListener(fileName,key,configEnvironmentSupport,fieldSupport);
            this.listeners.add(listener);
            return listener;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.fileNames = this.ppmtDynamicProperties.getWatchFiles();
        System.out.println("调用到了afterPropertiesSet方法");
    }

    @Override
    public int getOrder() {
        return 10000;
    }
}