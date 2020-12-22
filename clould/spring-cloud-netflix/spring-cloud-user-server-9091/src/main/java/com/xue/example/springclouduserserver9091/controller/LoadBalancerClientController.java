package com.xue.example.springclouduserserver9091.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

@RestController
public class LoadBalancerClientController {

    //    方式一
    //        @Bean
    //        //@LoadBalanced  开启客户端负载均衡，即restTemplate.getForObject 必须通过服务名称访问
    //        public RestTemplate restTemplate(){
    //            return  new RestTemplate();
    //        }
    //方式二
    @Bean("restTemplateDemo")
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder){
        return  restTemplateBuilder.build();
    }

    @Autowired
    @Qualifier("restTemplateDemo")
    RestTemplate restTemplate;

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @GetMapping("/user/orders")
    public String getUserOrders(HttpServletRequest request){
        request.getSession();
        String returnStr="";
        ServiceInstance serviceInstance=loadBalancerClient.choose("order-server-demo-9090");
        String requestUrl=String.format("http://%s:%s",serviceInstance.getHost(),serviceInstance.getPort()+"/order/demo/orders");
        System.out.println(requestUrl);
        returnStr+=restTemplate.getForObject(requestUrl,String.class);
        return returnStr;
   }

}
