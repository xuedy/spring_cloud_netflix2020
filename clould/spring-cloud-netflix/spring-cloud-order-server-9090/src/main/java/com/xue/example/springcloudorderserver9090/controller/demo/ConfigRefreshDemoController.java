package com.xue.example.springcloudorderserver9090.controller.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RefreshScope
@RequestMapping("/config/demo")
public class ConfigRefreshDemoController {

    @Value("${env}")
    String env;

    @GetMapping("/env")
    public String getOrderEnv(){
        log.info("env:{}",env);
        return env;
    }
}
