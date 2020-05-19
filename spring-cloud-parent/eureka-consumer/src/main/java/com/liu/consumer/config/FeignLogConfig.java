package com.liu.consumer.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignLogConfig {
    @Bean
    //记录完整信息
    public Logger.Level level(){
        return Logger.Level.FULL;
    }
}
