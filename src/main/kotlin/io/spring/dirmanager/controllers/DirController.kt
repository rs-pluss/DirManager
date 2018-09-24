package io.spring.dirmanager.controllers

import io.spring.dirmanager.catalog.service.DirService

import io.spring.dirmanager.catalog.structure.Directory
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class DirController(val service: DirService) {

    @RequestMapping("/dirs")
    fun getDirectories(): Iterable<Directory> {
        return service.getAllDirectories()
    }

    @RequestMapping("/dirs/{id}")
    fun getDirectoryContent(@RequestParam("id") id: Long): Directory {
        return service.obtainDirectoryContent(id)
    }

    @RequestMapping("/new_path")
    fun addNewDirectory(@RequestParam("path") path: String) {
        service.addNewDirectory(path)
    }
}