package com.springboot.feign.client.config

import brave.sampler.Sampler
import feign.Logger
import feign.Retryer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.concurrent.TimeUnit

@Configuration
class FeignClientConfig {

    @Bean
    fun feignClientRetryer(): Retryer {
        return Retryer.Default(50, TimeUnit.SECONDS.toMillis(2), 6)
    }

    @Bean
    fun feignClientLogLevel(): Logger.Level {
        return Logger.Level.FULL
    }

    // 配置Sleuth采样器
//    @Bean
//    fun sleuthSampler(): Sampler {
//        return Sampler.ALWAYS_SAMPLE
//    }
}
