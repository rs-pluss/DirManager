package io.spring.dirmanager.controllers

import io.spring.dirmanager.service.DirService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
class DirController() {
    
    @Autowired
    lateinit var service: DirService
    
    /**
     * Return list of all directories in directoryRepository
     */
    @RequestMapping("/")
    fun getDirectoryList(model: Model): String {
        model.addAttribute("dirList", service.getAllDirectories())
        return "index";
    }
    
    /**
     * Add new watching directory to directoryRepository
     */
    @RequestMapping(value = ["/"], method = [(RequestMethod.POST)])
    fun addNewDirectory(@RequestParam("path") path: String, model: Model): String {
        service.addNewDirectory(path)
        return "redirect:/"
    }
}