package com.wimilee.balance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author lwm
 */
@SpringBootApplication
public class EurekaBalanceApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaBalanceApplication.class);
    }
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
