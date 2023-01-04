package com.tj.exercise.ppmt.core.demo.Entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * @Author: tj
 * @Date: 2022/12/19 11:21
 */
@TableName("config_info")
public class ConfigInfoEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("config_file_name")
    private String configFileName;

    @TableField("config_item")
    private String configItem;

    @TableField("config_value")
    private String configValue;

    public String getConfigFileName() {
        return configFileName;
    }

    public void setConfigFileName(String configFileName) {
        this.configFileName = configFileName;
    }
    public String getConfigItem() {
        return configItem;
    }

    public void setConfigItem(String configItem) {
        this.configItem = configItem;
    }
    public String getConfigValue() {
        return configValue;
    }

    public void setConfigValue(String configValue) {
        this.configValue = configValue;
    }

    @Override
    public String toString() {
        return "ConfigInfoEntity{" +
                "configFileName=" + configFileName +
                ", configItem=" + configItem +
                ", configValue=" + configValue +
                "}";
    }
}

