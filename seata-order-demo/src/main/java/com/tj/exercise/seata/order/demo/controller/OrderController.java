package com.tj.exercise.seata.order.demo.controller;

import com.tj.exercise.seata.order.demo.entity.Order;
import com.tj.exercise.seata.order.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: tj
 * @Date: 2023/3/29 10:41
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/createOrder")
    public void createOrder(@RequestBody Order order) {
        // 创建订单
        orderService.createOrder(order);

    }
}
