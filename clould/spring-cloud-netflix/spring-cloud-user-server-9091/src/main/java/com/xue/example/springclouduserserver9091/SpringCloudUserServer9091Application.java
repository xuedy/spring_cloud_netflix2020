package com.xue.example.springclouduserserver9091;

import com.xue.example.springclouduserserver9091.registrar.EnableGcRegistrara;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.xue.example.feignclients","com.xue.example.springclouduserserver9091"})
@EnableFeignClients(basePackages = "com.xue.example.feignclients")
@EnableGcRegistrara
@EnableCircuitBreaker
public class SpringCloudUserServer9091Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudUserServer9091Application.class, args);
    }

}
