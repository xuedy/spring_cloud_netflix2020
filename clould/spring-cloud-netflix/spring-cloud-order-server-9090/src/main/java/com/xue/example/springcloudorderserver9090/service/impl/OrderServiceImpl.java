package com.xue.example.springcloudorderserver9090.service.impl;

import com.xue.example.springcloudorderserver9090.dto.OrderDto;
import com.xue.example.springcloudorderserver9090.service.IOrderService;

public class OrderServiceImpl implements IOrderService {
    @Override
    public String createOrder(OrderDto orderDto) {
        /**
         * 1 锁库存
         * 2 查询商品
         * 3 创建订单
         */
        return null;
    }
}
