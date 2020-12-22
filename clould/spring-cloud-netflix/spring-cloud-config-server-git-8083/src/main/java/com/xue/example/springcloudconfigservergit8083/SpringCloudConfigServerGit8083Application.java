package com.xue.example.springcloudconfigservergit8083;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class SpringCloudConfigServerGit8083Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigServerGit8083Application.class, args);
    }

}
