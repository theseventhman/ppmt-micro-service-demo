package com.tj.exercise.observer.demo.publish.subscribe;

import com.tj.exercise.observer.demo.OrderNotifyObserver;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

/**
 * @Author: tj
 * @Date: 2022/12/3 19:53
 */
@Slf4j
@Service
public class OrderNotifyListener implements ApplicationListener<PlaceOrderEvent> {
    private final static Logger logger = LoggerFactory.getLogger(OrderNotifyListener.class);

    @Override
    public void onApplicationEvent(PlaceOrderEvent placeOrderEvent) {
        logger.info("[afterPlaceOrder] notify.");
    }
}
