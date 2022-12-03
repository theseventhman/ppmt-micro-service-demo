package com.tj.exercise.observer.demo;

import com.tj.exercise.observer.demo.publish.subscribe.PlaceOrderEvent;
import com.tj.exercise.observer.demo.publish.subscribe.PlaceOrderEventMessage;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: tj
 * @Date: 2022/11/29 23:02
 */
@Slf4j
@Service
public class OrderServiceImpl extends OrderSubject implements OrderService {


   @Autowired
    private ApplicationEventPublisher publisher;
    private final static Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
    @Autowired
    private List<OrderObserver> orderObserverList;
    @Override
    public String placeOrder(Integer id){
        logger.info("[placeOrder] start.");
        PlaceOrderEventMessage placeOrderEventMessage = new PlaceOrderEventMessage();
        publisher.publishEvent(new PlaceOrderEvent(placeOrderEventMessage));
        logger.info(":[placeOrder] end");
        return id.toString();
    }


//    @Override
//    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
//        this.publisher = applicationEventPublisher;
//    }
}
