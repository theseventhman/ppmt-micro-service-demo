package com.tj.exercise.observer.demo.publish.subscribe;

import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

/**
 * @Author: tj
 * @Date: 2022/12/1 22:18
 */

public class PlaceOrderEvent extends ApplicationEvent {
    public PlaceOrderEvent(PlaceOrderEventMessage source) {
        super(source);
    }
}
