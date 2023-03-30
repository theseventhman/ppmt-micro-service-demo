package com.tj.exercise.demo.seata.stock.demo.controller;


import com.tj.exercise.demo.seata.stock.demo.service.StockService;
import com.tj.exercise.seata.demo.api.dto.ReduceStockRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: tj
 * @Date: 2023/3/29 11:09
 */
@RestController
@RequestMapping("/stock")
public class StockController {
    @Autowired
    private StockService stockService;

    @PostMapping("/reduceStock")
    public void reduceStock(@RequestBody ReduceStockRequest request) {
        stockService.reduceStock(request.getProductId(), request.getAmount());
    }
}
