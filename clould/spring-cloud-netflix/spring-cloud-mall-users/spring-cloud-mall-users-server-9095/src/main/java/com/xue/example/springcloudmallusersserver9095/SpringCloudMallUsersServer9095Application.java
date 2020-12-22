package com.xue.example.springcloudmallusersserver9095;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.xue.example.springcloudmallusersserver9095.mapper.persistence")
@SpringBootApplication
public class SpringCloudMallUsersServer9095Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudMallUsersServer9095Application.class, args);
    }

}
