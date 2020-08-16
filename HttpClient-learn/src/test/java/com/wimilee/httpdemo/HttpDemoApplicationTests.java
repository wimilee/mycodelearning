package com.wimilee.httpdemo;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HttpDemoApplication.class)
public class HttpDemoApplicationTests {
	private final Logger logger = LoggerFactory.getLogger(HttpDemoApplicationTests.class);
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private CloseableHttpClient httpClient;

	@Test
	public void restTemplateHttpGet() {
		logger.info("test my blog website");
		HttpHeaders httpHeaders = restTemplate.headForHeaders("http://blog.wimilee.work/2020/04/20/hello-world/");
		System.out.println("httpHeaders = " + httpHeaders);
	}

	@Test
	public void HttpClientGet(){
		//创建get请求
		HttpGet httpGet = new HttpGet("http://blog.wimilee.work/2020/04/20/hello-world/");
		//设置响应方式
		CloseableHttpResponse response = null;
		try {
			// 由客户端执行(发送)Get请求
			response = httpClient.execute(httpGet);
			// 从响应模型中获取响应实体
			HttpEntity responseEntity = response.getEntity();
			System.out.println("响应状态为:" + response.getStatusLine());
			if (responseEntity != null) {
				System.out.println("响应内容长度为:" + responseEntity.getContentLength());
				System.out.println("响应内容为:" + EntityUtils.toString(responseEntity));
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			try {
				// 释放资源
				if (httpClient != null) {
					httpClient.close();
				}
				if (response != null) {
					response.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}



}