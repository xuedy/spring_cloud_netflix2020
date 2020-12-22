package com.xue.example.orderservice.controller;


import com.xue.example.api.R;
import com.xue.example.orderservice.dto.OrderDto;
import com.xue.example.orderservice.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class OrderController {

    @Autowired
    IOrderService orderService;

    @PostMapping("/order")
    public R order(@RequestBody @Validated OrderDto orderDto, BindingResult bindingResult){
        orderDto.validData(bindingResult);
        String orderId=orderService.createOrder(orderDto);
        return new R.Builder<>().setData(orderId).buildOK();
    }
}
