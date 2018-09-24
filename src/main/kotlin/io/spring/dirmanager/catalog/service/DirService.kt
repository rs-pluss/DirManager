package io.spring.dirmanager.catalog.service

import io.spring.dirmanager.catalog.structure.Attachment
import io.spring.dirmanager.catalog.structure.Directory
import io.spring.dirmanager.data.DirRepository
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service
import java.io.File
import java.util.*

@Service
class DirService(val jdbcTemplate: JdbcTemplate, val repository: DirRepository) {
    fun getAllDirectories(): MutableIterable<Directory> {
        return repository.findAll()
    }

    fun obtainDirectoryContent(id: Long): Directory {
        return repository.findById(id).get()
    }

    fun addNewDirectory(path: String) {
        val folder = File(path)
        val directory = Directory()
        directory.name = folder.name

        directory.date = Date()
        for (file in folder.listFiles()) {
            val attachment = Attachment()
            attachment.name = file.name
            attachment.size = file.length()
            attachment.isDirectory = file.isDirectory
        }
        repository.save(directory)
    }
}