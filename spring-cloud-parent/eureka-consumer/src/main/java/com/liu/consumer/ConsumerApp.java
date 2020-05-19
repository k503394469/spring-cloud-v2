package com.liu.consumer;

import com.liu.consumer.config.FuzaijunhengRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.client.RestTemplate;
//激活DiscoveryClient,动态获取消息提供者地址
@EnableDiscoveryClient
//激活Eureka客户端
@EnableEurekaClient
//配置Ribbon负载均衡策略
/**
 * name:设置服务提供方应用名
 * configuration:设置负载均衡策略
 */
//@RibbonClient(name = "EUREKA-PROVIDER",configuration = FuzaijunhengRule.class)
//开启Feign功能
@EnableFeignClients
@SpringBootApplication
public class ConsumerApp {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApp.class, args);
    }
}
