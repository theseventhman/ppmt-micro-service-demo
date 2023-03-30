package com.tj.exercise.seata.demo.api.dto;

import lombok.Data;

/**
 * @Author: tj
 * @Date: 2023/3/29 11:10
 */
@Data
public class ReduceStockRequest {
    private Long productId;
    private Integer amount;
}
