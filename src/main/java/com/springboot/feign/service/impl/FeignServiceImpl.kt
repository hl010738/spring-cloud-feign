package com.springboot.feign.service.impl

import com.springboot.eureka.client.domain.Parent
import com.springboot.eureka.client.domain.Student
import com.springboot.feign.client.EurekaClientFeign
import com.springboot.feign.service.FeignService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FeignServiceImpl(): FeignService {

    @Autowired
    private lateinit var eurekaClientFeign: EurekaClientFeign

    override fun infoByFeign(): String {
        return eurekaClientFeign.infoByFeign()
    }

    override fun getStudentByFeign(name: String, address: String): Student? {
        return eurekaClientFeign.getStudentByFeign(name, address)
    }

    override fun postStudentByFeign(parent: Parent): Student? {
        return eurekaClientFeign.postStudentByFeign(parent)
    }
}
