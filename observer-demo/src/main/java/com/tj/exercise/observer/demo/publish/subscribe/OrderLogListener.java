package com.tj.exercise.observer.demo.publish.subscribe;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

import java.security.AlgorithmConstraints;

/**
 * @Author: tj
 * @Date: 2022/12/3 19:49
 */
@Slf4j
@Service
public class OrderLogListener implements ApplicationListener<PlaceOrderEvent> {
    private final static Logger logger = LoggerFactory.getLogger(OrderLogListener.class);
    @Override
    public void onApplicationEvent(PlaceOrderEvent placeOrderEvent){
        logger.info("[afterPlaceOrder] log.");
    }
}
