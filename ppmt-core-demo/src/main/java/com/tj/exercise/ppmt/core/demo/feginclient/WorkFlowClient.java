package com.tj.exercise.ppmt.core.demo.feginclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: tj
 * @Date: 2022/11/20 22:19
 */
@FeignClient(value = "ppmt-workflow/workflow")
public interface WorkFlowClient {
    @GetMapping("getId")
    String getId(@RequestParam("id") Long id);
}
