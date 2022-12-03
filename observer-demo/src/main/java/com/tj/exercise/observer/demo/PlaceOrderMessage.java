package com.tj.exercise.observer.demo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: tj
 * @Date: 2022/11/29 22:30
 */
@Data
public class PlaceOrderMessage implements Serializable {
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
