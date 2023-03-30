package com.tj.exercise.seata.order.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tj.exercise.seata.order.demo.entity.Order;

/**
 * @Author: tj
 * @Date: 2023/3/28 10:46
 */
public interface OrderService extends IService<Order> {
    void createOrder(Order order);

    void reduceStock(Long productId, Integer amount);
}
