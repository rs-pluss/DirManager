package io.spring.dirmanager

import io.spring.dirmanager.service.DirService
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class DirManagerApplicationTests {

    @Autowired
    lateinit var dirService: DirService

    @Test
    fun contextLoads() {
    }


}
