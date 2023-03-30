package com.tj.exercise.seata.order.demo.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tj.exercise.seata.demo.api.dto.ReduceStockRequest;
import com.tj.exercise.seata.order.demo.entity.Order;
import com.tj.exercise.seata.order.demo.feign.StockFeignClient;
import com.tj.exercise.seata.order.demo.mapper.OrderMapper;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: tj
 * @Date: 2023/3/28 10:47
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private StockFeignClient stockService;
    @GlobalTransactional(name = "create-order", rollbackFor = Exception.class)
    @Override
    public void createOrder(Order order) {
        // 插入订单记录
        orderMapper.insert(order);
        reduceStock(order.getProductId(),order.getAmount());
    }

    @Override
    public void reduceStock(Long productId, Integer amount) {
        // 调用库存微服务扣减库存
        ReduceStockRequest request = new ReduceStockRequest();
        request.setProductId(productId);
        request.setAmount(amount);
        stockService.reduceStock(request);
    }

}
