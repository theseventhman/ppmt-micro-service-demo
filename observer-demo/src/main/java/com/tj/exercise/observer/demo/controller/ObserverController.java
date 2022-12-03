package com.tj.exercise.observer.demo.controller;

import com.tj.exercise.observer.demo.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: tj
 * @Date: 2022/12/3 22:24
 */
@RestController
@RequestMapping("/observer")
public class ObserverController {

    @Autowired
    private OrderService orderService;
    @GetMapping("getId")
    public String getId(@RequestParam("id") Integer id){
        return orderService.placeOrder(id);
    }
}
