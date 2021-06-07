package com.springboot.feign.client

import com.springboot.eureka.client.domain.Parent
import com.springboot.eureka.client.domain.Student
import com.springboot.feign.client.config.FeignClientConfig
import com.springboot.feign.client.config.FeignClientInterceptorConfig
import com.springboot.feign.client.hystrix.EurekaClientFeignHystrix
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam

// configuration 指定Feign 的配置
// 如果不指定则会默认全局配置
// Feign 可以创建多个配置
@FeignClient(value = "eureka-client", configuration = [FeignClientConfig::class, FeignClientInterceptorConfig::class],
                fallback = EurekaClientFeignHystrix::class)
interface EurekaClientFeign {

    @GetMapping(value = ["/info"])
    fun infoByFeign(): String

    @GetMapping("/getStudent")
    fun getStudentByFeign(@RequestParam("name") name: String, @RequestParam("address") address: String): Student?

    @PostMapping("/postStudent")
    fun postStudentByFeign(@RequestBody parent: Parent): Student?
}
