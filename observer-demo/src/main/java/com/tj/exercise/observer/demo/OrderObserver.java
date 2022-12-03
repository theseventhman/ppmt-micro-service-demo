package com.tj.exercise.observer.demo;

/**
 * @Author: tj
 * @Date: 2022/11/29 22:30
 */
public interface OrderObserver {
    void afterPlaceOrder(PlaceOrderMessage placeOrderMessage);
}
