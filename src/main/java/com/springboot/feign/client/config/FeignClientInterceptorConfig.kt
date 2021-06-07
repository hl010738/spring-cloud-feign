package com.springboot.feign.client.config

import feign.RequestInterceptor
import feign.RequestTemplate
import org.springframework.context.annotation.Configuration

@Configuration
class FeignClientInterceptorConfig: RequestInterceptor {

    override fun apply(template: RequestTemplate) {
        println("feign interceptor entered")
        template.header("authKey", "myKeyInfo")
    }
}
