import io.spring.DirManager.catalog.service.DirService
import io.spring.DirManager.catalog.structure.Directory
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class DirController(val service: DirService) {

    @RequestMapping("/dirs")
    fun getDirectories(): Iterable<Directory> {
        return service.getAllDirectories()
    }

    @RequestMapping("/dirs/{id}")
    fun getDirectoryContent() {
        return
    }

}

