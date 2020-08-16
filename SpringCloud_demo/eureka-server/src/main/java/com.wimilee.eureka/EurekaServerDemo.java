package com.wimilee.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author lwm
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerDemo {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerDemo.class);
    }
}
