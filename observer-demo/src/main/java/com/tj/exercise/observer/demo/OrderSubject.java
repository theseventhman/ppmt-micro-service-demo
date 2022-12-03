package com.tj.exercise.observer.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author: tj
 * @Date: 2022/11/29 22:44
 */
public abstract class OrderSubject {
    private List<OrderObserver> orderObserverList = new ArrayList<OrderObserver>();

    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(6,12,6, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(30));

    public void addObserver(OrderObserver orderObserver){
        this.orderObserverList.add(orderObserver);
    }

    public void deleteObserver(OrderObserver orderObserver){
        this.orderObserverList.remove(orderObserver);
    }

    public void notifyObservers(final PlaceOrderMessage orderMessage){
        for(final OrderObserver orderObserver : orderObserverList){
            threadPoolExecutor.execute(()->{
                orderObserver.afterPlaceOrder(orderMessage);
            });
        }
    }
}
