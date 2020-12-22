package com.xue.example.springclouduserserver9091.controller;


import com.xue.example.feignclients.GoodsServiceFeignClient;
import com.xue.proposal.clients.ProductTypeConfigFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/goods")
public class OpenFeignController {
    @Autowired
    GoodsServiceFeignClient goodsServiceFeignClient;

    @GetMapping("/all")
    public String getAllGoods(){
       return goodsServiceFeignClient.getGoods();
    }
}
