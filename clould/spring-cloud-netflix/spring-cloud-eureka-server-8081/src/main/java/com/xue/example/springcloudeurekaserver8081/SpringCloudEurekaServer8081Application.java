package com.xue.example.springcloudeurekaserver8081;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 *  http://localhost:8081/
 */
@EnableEurekaServer
@SpringBootApplication
public class SpringCloudEurekaServer8081Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudEurekaServer8081Application.class, args);
    }

}
