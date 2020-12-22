package com.xue.example.springcloudgateway8080;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.xue.example.clients")
@SpringBootApplication
public class SpringCloudGateway8080Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudGateway8080Application.class, args);
    }

}
