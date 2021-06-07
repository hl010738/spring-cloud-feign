package com.springboot.feign.controller

import com.springboot.eureka.client.domain.Parent
import com.springboot.eureka.client.domain.Student
import com.springboot.feign.service.FeignService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class FeignController {

    @Autowired
    private lateinit var feignService: FeignService

    @GetMapping("/infoByFeign")
    fun infoByFeign(): String {
        return this.feignService.infoByFeign()
    }

    @GetMapping("/getStudentByFeign")
    fun getStudentByFeign(): Student? {
        return this.feignService.getStudentByFeign("aaa", "shanghai")
    }

    @PostMapping("/postStudentByFeign")
    fun postStudentByFeign(): Student? {

        var parent = Parent()

        parent.id = 30
        parent.name = "bbb"
        parent.address = "beijing"

        return this.feignService.postStudentByFeign(parent)
    }
}
