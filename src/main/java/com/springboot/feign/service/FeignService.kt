package com.springboot.feign.service

import com.springboot.eureka.client.domain.Parent
import com.springboot.eureka.client.domain.Student

interface FeignService {

    fun infoByFeign(): String

    fun getStudentByFeign(name: String, address: String): Student?

    fun postStudentByFeign(parent: Parent): Student?
}
