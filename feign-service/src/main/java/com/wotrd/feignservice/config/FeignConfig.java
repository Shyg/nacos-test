package com.wotrd.feignservice.config;

import feign.Logger;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static java.util.concurrent.TimeUnit.SECONDS;

@Configuration
public class FeignConfig {

    @Bean
    public Retryer feignRetryer() {
//        return  Retryer.NEVER_RETRY;
        return new Retryer.Default(100, SECONDS.toMillis(1), 5);
    }

    @Bean
    Logger.Level feignLoggerLevel() {
        // 设置日志
        return Logger.Level.BASIC;
    }
}
