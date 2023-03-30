package com.tj.exercise.demo.seata.stock.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tj.exercise.demo.seata.stock.demo.entity.Stock;

/**
 * @Author: tj
 * @Date: 2023/3/29 10:58
 */
public interface StockService extends IService<Stock> {

    void reduceStock(Long productId, Integer amount);
}
