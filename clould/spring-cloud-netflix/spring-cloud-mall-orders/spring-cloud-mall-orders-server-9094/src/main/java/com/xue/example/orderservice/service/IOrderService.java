package com.xue.example.orderservice.service;


import com.xue.example.orderservice.dto.OrderDto;

public interface IOrderService {

    /**
     * 下单
     * @param orderDto
     * @return
     */
    String createOrder(OrderDto orderDto);
}
