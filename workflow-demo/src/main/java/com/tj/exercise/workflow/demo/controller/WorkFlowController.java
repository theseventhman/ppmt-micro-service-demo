package com.tj.exercise.workflow.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: tj
 * @Date: 2022/11/20 22:10
 */
@RestController
@RequestMapping("/workflow")
public class WorkFlowController {
    @GetMapping("getId")
    public String getId(@RequestParam("id") Long id){
        return id.toString();
    }
}
