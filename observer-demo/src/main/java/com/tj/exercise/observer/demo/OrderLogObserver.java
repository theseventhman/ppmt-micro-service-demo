package com.tj.exercise.observer.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @Author: tj
 * @Date: 2022/11/29 22:39
 */
@Service
public class OrderLogObserver implements OrderObserver {
    private final static Logger logger = LoggerFactory.getLogger(OrderLogObserver.class);
    @Override
    public void afterPlaceOrder(PlaceOrderMessage placeOrderMessage) {
        logger.info("[afterPlaceOrder] log");
    }
}
