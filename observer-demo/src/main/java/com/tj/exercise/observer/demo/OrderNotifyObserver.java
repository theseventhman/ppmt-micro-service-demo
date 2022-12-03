package com.tj.exercise.observer.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @Author: tj
 * @Date: 2022/11/29 22:40
 */
@Service
public class OrderNotifyObserver implements OrderObserver {
    private final static Logger logger = LoggerFactory.getLogger(OrderNotifyObserver.class);
    @Override
    public void afterPlaceOrder(PlaceOrderMessage placeOrderMessage) {
        logger.info("[afterPlaceOrder] notify");
    }
}
