package io.spring.dirmanager

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DirManagerApplication

fun main(args: Array<String>) {
    runApplication<DirManagerApplication>(*args)
}
