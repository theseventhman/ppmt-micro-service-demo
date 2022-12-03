package com.tj.exercise.observer.demo;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @Author: tj
 * @Date: 2022/11/29 22:31
 */
@Slf4j
@Service
public class OrderMetricsObserver implements OrderObserver {
    private final static Logger logger = LoggerFactory.getLogger(OrderMetricsObserver.class);
    @Override
    public void afterPlaceOrder(PlaceOrderMessage placeOrderMessage) {
        logger.info("[afterPlaceOrder] metrics");
    }
}
