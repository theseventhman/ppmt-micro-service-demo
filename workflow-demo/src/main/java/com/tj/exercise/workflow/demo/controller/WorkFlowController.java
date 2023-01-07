package com.tj.exercise.workflow.demo.controller;

import com.tj.exercise.workflow.demo.config.MsgSettingConfig;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private MsgSettingConfig msgSettingConfig;
    @GetMapping("getId")
    public String getId(@RequestParam("id") Long id){
        return id.toString();
    }

    @GetMapping("getMsgAccount")
    public String getMsgAccount(){
        return msgSettingConfig.getMsgAccount();
    }
}
