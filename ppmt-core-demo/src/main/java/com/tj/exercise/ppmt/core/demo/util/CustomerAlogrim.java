//package com.tj.exercise.ppmt.core.demo.util;
//
//import groovy.util.logging.Slf4j;
//import org.apache.shardingsphere.sharding.api.sharding.standard.PreciseShardingValue;
//import org.apache.shardingsphere.sharding.api.sharding.standard.RangeShardingValue;
//import org.apache.shardingsphere.sharding.api.sharding.standard.StandardShardingAlgorithm;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import java.util.Collection;
//import java.util.Properties;
//import java.util.logging.Logger;
//
///**
// * @Author: tj
// * @Date: 2022/11/22 22:33
// */
//@Component
//@Slf4j
//public class CustomerAlogrim implements StandardShardingAlgorithm<String> {
//    @Value("${server.port}")
//    private String serverport;
//
//    public String doSharding(Collection<String> collection, PreciseShardingValue<String> preciseShardingValue) {
//        return null;
//    }
//
//    public Collection<String> doSharding(Collection<String> collection, RangeShardingValue<String> rangeShardingValue) {
//        return null;
//    }
//
//    public void init() {
//        System.out.println("注册结果"+serverport);
//    }
//
//    public String getType() {
//        return null;
//    }
//
//    public Properties getProps() {
//        return null;
//    }
//
//    public void setProps(Properties properties) {
//
//    }
//}
