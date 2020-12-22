package com.xue.example.springcloudhystrixdashboard8084;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * http://localhost:8084/hystrix
 */
@EnableHystrixDashboard
@SpringBootApplication
public class SpringCloudHystrixDashboard8084Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudHystrixDashboard8084Application.class, args);
    }

}
