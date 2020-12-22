package com.xue.proposal.springcloudproposaleurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SpringCloudProposalEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudProposalEurekaServerApplication.class, args);
    }

}
