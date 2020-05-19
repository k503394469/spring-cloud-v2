package com.liu.consumer.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 负载均衡配置类
 */
@Configuration
public class FuzaijunhengRule {
    @Bean
    public IRule rule(){
        return new RandomRule();//返回值决定均衡策略
    }
}
