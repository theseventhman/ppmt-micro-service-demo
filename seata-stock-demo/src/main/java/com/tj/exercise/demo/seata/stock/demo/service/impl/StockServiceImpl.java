package com.tj.exercise.demo.seata.stock.demo.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tj.exercise.demo.seata.stock.demo.entity.Stock;
import com.tj.exercise.demo.seata.stock.demo.mapper.StockMapper;
import com.tj.exercise.demo.seata.stock.demo.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: tj
 * @Date: 2023/3/29 10:59
 */
@Service
public class StockServiceImpl extends ServiceImpl<StockMapper, Stock> implements StockService {
    @Autowired
    private StockMapper stockMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void reduceStock(Long productId, Integer amount) {
        // 查询库存信息
        QueryWrapper<Stock> wrapper = new QueryWrapper<>();
        wrapper.eq("productId",productId);
        Stock stock = stockMapper.selectOne(wrapper);
        if (ObjectUtil.isNotNull(stock)){
        // 判断库存是否充足
        if(stock.getQuantity() < amount) {
            throw new RuntimeException("库存不足");
        }
        // 扣减库存
        stock.setQuantity(stock.getQuantity() - amount);
        stockMapper.updateById(stock);
        }
    }
}
