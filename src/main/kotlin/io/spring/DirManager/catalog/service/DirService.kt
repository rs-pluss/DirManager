package io.spring.DirManager.catalog.service

import io.spring.DirManager.catalog.structure.Directory
import io.spring.DirManager.data.DirRepository
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service

@Service
class DirService(val jdbcTemplate: JdbcTemplate, val repository: DirRepository) {
    fun getAllDirectories(): MutableIterable<Directory> {
        return repository.findAll()
    }

    fun obtainDirectoryContent(id: Long) {
        repository.findById(id)
    }
}