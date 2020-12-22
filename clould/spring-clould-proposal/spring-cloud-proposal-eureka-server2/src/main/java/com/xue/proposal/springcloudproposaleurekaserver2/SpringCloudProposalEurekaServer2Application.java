package com.xue.proposal.springcloudproposaleurekaserver2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SpringCloudProposalEurekaServer2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudProposalEurekaServer2Application.class, args);
    }

}
