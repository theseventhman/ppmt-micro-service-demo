package com.tj.exercise.observer.demo.publish.subscribe;

import java.io.Serializable;

/**
 * @Author: tj
 * @Date: 2022/12/1 22:19
 */
public class PlaceOrderEventMessage implements Serializable {
    /**
     * 订单号
     */
    private String orderId;
    /**
     * 订单状态
     */
    private Integer orderStatus;
    /**
     * 下单用户ID
     */
    private String userId;
}
