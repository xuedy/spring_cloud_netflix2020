package com.xue.example.springcloudorderserver9090.service;

import com.xue.example.springcloudorderserver9090.dto.OrderDto;

public interface IOrderService {
    String createOrder(OrderDto orderDto);
}
