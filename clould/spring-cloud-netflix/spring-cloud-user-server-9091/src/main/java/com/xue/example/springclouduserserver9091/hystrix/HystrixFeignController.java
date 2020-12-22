package com.xue.example.springclouduserserver9091.hystrix;

import com.xue.example.feignclients.GoodsServiceFeignClient;
import com.xue.proposal.clients.ProductTypeFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HystrixFeignController {
    //HystrixFeignController
    @Autowired
    GoodsServiceFeignClient goodsServiceFeignClient;
    @GetMapping("/queryOrd")
    public String queryOrd(){
        System.out.println("test");
        return goodsServiceFeignClient.getGoods();
    }

    @PostMapping("/insert")
    public int insert(){
        System.out.println("test");
        return goodsServiceFeignClient.addGoods(null);
    }

}
