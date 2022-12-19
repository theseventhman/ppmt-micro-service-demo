package com.tj.exercise.ppmt.core.demo.controller;

import com.tj.exercise.ppmt.core.demo.Entity.ConfigInfoEntity;
import com.tj.exercise.ppmt.core.demo.service.ConfigInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: tj
 * @Date: 2022/12/15 23:06
 */

@RestController
@RequestMapping("config")
@Api(tags = "获取配置信息")
public class ConfigInfoController {
    @Autowired
    private ConfigInfoService configInfoService;

    @ApiOperation("获取配置信息")
    @GetMapping("/getConfigInfos")
    public List<ConfigInfoEntity> getConfigInfos(){
        return configInfoService.list();
    }
}
