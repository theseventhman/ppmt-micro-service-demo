package com.tj.exercise.seata.order.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tj.exercise.seata.order.demo.entity.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: tj
 * @Date: 2023/3/28 10:50
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

}
