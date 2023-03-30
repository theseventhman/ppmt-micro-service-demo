package com.tj.exercise.demo.seata.stock.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tj.exercise.demo.seata.stock.demo.entity.Stock;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: tj
 * @Date: 2023/3/29 10:56
 */
@Mapper
public interface StockMapper extends BaseMapper<Stock> {

}
