package com.tj.exercise.seata.order.demo.feign;

import com.tj.exercise.seata.demo.api.dto.ReduceStockRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author: tj
 * @Date: 2023/3/29 11:13
 */
@FeignClient(value = "seata-stock-service/stock")
public interface StockFeignClient {
    @PostMapping("/reduceStock")
    public void reduceStock(@RequestBody ReduceStockRequest request);
}
