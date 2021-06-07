package com.springboot.feign.client.hystrix

import com.springboot.eureka.client.domain.Parent
import com.springboot.eureka.client.domain.Student
import com.springboot.feign.client.EurekaClientFeign
import org.springframework.stereotype.Component

@Component
class EurekaClientFeignHystrix: EurekaClientFeign {

    override fun infoByFeign(): String {
        return "This is Feign with Hystrix"
    }

    override fun getStudentByFeign(name: String, address: String): Student? {
        return null
    }

    override fun postStudentByFeign(parent: Parent): Student? {
        return null
    }
}
