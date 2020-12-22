package com.xue.example.springclouduserserver9091.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//自动刷新,git做配置中心的话，没有作用
@RefreshScope
@RestController
public class ConfigLoadTestController {
    //Environment 去获取指定配置
    @Value("${env}")
    private String env;
   @GetMapping("/env")
    public String getEnv(){
        return env;
    }
}
