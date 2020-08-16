package com.wimilee.userserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;
/**
 * @author lwm
 */
@SpringBootApplication
@MapperScan("com.wimilee.userserver.user.mapper")
@EnableDiscoveryClient // 开启Eureka客户端发现功能
public class UserServiceDemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(UserServiceDemoApplication.class, args);
	}
}