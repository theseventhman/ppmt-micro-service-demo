package com.tj.exercise.ppmt.core.demo.controller;

import com.tj.exercise.ppmt.core.demo.feginclient.WorkFlowClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: tj
 * @Date: 2022/11/20 22:21
 */
@RestController
@RequestMapping("core")
public class CoreController {
    @Autowired
    private WorkFlowClient workFlowClient;

    @GetMapping("getId")
    public String getId(@RequestParam("id") Long id){
        return workFlowClient.getId(id);
    }
}
