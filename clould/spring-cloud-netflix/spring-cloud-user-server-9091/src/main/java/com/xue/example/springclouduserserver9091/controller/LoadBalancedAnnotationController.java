package com.xue.example.springclouduserserver9091.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class LoadBalancedAnnotationController {

    //    方式一
    //    开启客户端负载均衡，即restTemplate.getForObject 必须通过服务名称访问
    @Bean("restTemplateNew")
    @LoadBalanced
    public RestTemplate restTemplate(){
        return  new RestTemplate();
    }
    //    方式二
    @Bean("restTemplateBuild")
    @LoadBalanced
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder){
        return  restTemplateBuilder.build();
    }

    @Autowired
    @Qualifier("restTemplateNew")
    RestTemplate restTemplate;

    @GetMapping("/user/orders2")
    public String getUserOrders(){
        String returnStr="";
        String requestUrl="http://order-server-demo-9090/order/demo/orders";
        System.out.println(requestUrl);
        returnStr+=restTemplate.getForObject(requestUrl,String.class);
        return returnStr;
   }

}
