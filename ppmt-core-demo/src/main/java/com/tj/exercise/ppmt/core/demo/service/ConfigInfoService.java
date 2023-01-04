package com.tj.exercise.ppmt.core.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tj.exercise.ppmt.core.demo.Entity.ConfigInfoEntity;
import com.tj.exercise.ppmt.core.project.api.demo.dto.ConfigDto;

import java.util.List;

/**
 * @Author: tj
 * @Date: 2022/12/19 11:22
 */
public interface ConfigInfoService extends IService<ConfigInfoEntity> {
     List<ConfigDto> getConfiginfos();
}
