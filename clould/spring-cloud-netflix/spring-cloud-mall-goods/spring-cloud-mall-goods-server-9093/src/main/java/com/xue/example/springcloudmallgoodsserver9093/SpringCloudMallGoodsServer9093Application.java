package com.xue.example.springcloudmallgoodsserver9093;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@MapperScan("com.xue.example.goodsservice.mapper.persistence")
//@ComponentScan("com.xue.example")
@EnableTransactionManagement
@SpringBootApplication
public class SpringCloudMallGoodsServer9093Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudMallGoodsServer9093Application.class, args);
    }

}
