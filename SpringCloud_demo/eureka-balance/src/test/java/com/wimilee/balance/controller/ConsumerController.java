package com.wimilee.balance.controller;

import com.wimilee.balance.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("consumer")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("{id}")
    public User queryById(@PathVariable("id") Long id){
        // 根据服务id(spring.application.name)，获取服务实例列表
        List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
        // 取出一个服务实例
        ServiceInstance instance = instances.get(0);
        // 从实例中获取host和port，组成url
        String url = String.format("http://%s:%s/user/%s", instance.getHost(), instance.getPort(), id);
        // 查询
        User user = restTemplate.getForObject(url, User.class);
        return user;
    }
}