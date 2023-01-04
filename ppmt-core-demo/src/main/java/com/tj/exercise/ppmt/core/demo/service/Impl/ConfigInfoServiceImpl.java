package com.tj.exercise.ppmt.core.demo.service.Impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tj.exercise.ppmt.core.demo.Entity.ConfigInfoEntity;
import com.tj.exercise.ppmt.core.demo.mapper.ConfigInfoMapper;
import com.tj.exercise.ppmt.core.demo.service.ConfigInfoService;
import com.tj.exercise.ppmt.core.project.api.demo.dto.ConfigDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: tj
 * @Date: 2022/12/19 11:23
 */
@Service
public class ConfigInfoServiceImpl extends ServiceImpl<ConfigInfoMapper, ConfigInfoEntity> implements ConfigInfoService {

    @Override
    public List<ConfigDto> getConfiginfos() {
        List<ConfigInfoEntity> configInfoEntityList = this.list();
        List<ConfigDto> configDtos = new ArrayList<>();
        if(CollectionUtil.isNotEmpty(configInfoEntityList)) {
            Map<String, List<ConfigInfoEntity>> fileNameGroupMap = configInfoEntityList.stream().collect(Collectors.groupingBy((ConfigInfoEntity::getConfigFileName)));

            for (Map.Entry<String, List<ConfigInfoEntity>> entry : fileNameGroupMap.entrySet()){
                ConfigDto configDto = new ConfigDto();
                configDto.setConfigFileName(entry.getKey());
                List<ConfigInfoEntity> configInfoEntities = entry.getValue();
                if(CollectionUtil.isNotEmpty(configInfoEntities)){
                   StringBuilder stringBuilder = new StringBuilder();
                   for(ConfigInfoEntity configInfoEntity : configInfoEntities){
                       stringBuilder.append(configInfoEntity.getConfigItem()+"="+configInfoEntity.getConfigValue());
                       stringBuilder.append(System.getProperty("line.separator"));
                   }
                   configDto.setValue(stringBuilder.toString());
                   configDtos.add(configDto);

                }
            }
        }
        return configDtos;
    }
}
