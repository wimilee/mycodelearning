package com.wimilee.balance;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EurekaBalanceApplication.class)
public class GetBalanceTest {
    @Autowired
    private RestTemplate restTemplate;
    @Test
    public void balanceTest(){
        String url = "http://eureka-server-demo/eureka";
        Object o = restTemplate.getForObject(url,Object.class);
        System.out.println("o = " + o);
    }
}
