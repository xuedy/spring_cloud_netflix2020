package com.xue.example.springcloudorderserver9090.controller.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/order/demo")
public class OrderServerDemoController {
    @Value("${server.port}")
    int port;

    @GetMapping("/orders")
    public String getAllOrders(){
        log.info("port:{}",port);
       return "ALL ORDERS";
    }
}
