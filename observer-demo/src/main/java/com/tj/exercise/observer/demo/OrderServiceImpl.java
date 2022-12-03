package com.tj.exercise.observer.demo;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: tj
 * @Date: 2022/11/29 23:02
 */
@Slf4j
@Service
public class OrderServiceImpl extends OrderSubject implements OrderService {
    private final static Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
    @Autowired
    private List<OrderObserver> orderObserverList;
    @Override
    public String placeOrder(Integer id){
        this.notifyObservers(new PlaceOrderMessage());
        logger.info(":[placeOrder] end");
        return id.toString();
    }
}
