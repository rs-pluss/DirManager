package io.spring.dirmanager.service

import io.spring.dirmanager.catalog.structure.Attachment
import io.spring.dirmanager.catalog.structure.Directory
import io.spring.dirmanager.data.AttachmentRepository
import io.spring.dirmanager.data.DirRepository
import org.codehaus.plexus.util.FileUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service
import java.io.File
import java.util.*

@Service
class DirService(val jdbcTemplate: JdbcTemplate, val directoryRepository: DirRepository, val attachmentRepository: AttachmentRepository) {
    
    /**
     * return all directories from repository
     */
    fun getAllDirectories(): List<Directory> {
        return directoryRepository.findAll().toMutableList()
    }
    
    /**
     * Return attachment of the directory with specific id
     */
    fun obtainDirectoryAttachment(id: Long): Directory {
        return directoryRepository.findById(id).get()
    }
    
    /**
     * Create directory by the path and add them to repository
     */
    fun addNewDirectory(path: String) {
        val folder = File(path)
        val directory = Directory()
        directory.name = path
        directory.date = Date()
        directoryRepository.save(directory)
        for (file in folder.listFiles()) {
            val attachment = Attachment()
            attachment.name = file.name
            attachment.size =
                    if (file.isDirectory) FileUtils.sizeOfDirectory(file) else file.length()
            attachment.isDirectory = file.isDirectory
            attachment.directory = directory
            attachmentRepository.save(attachment)
            directory.addAttachment(attachment)
        }
        directoryRepository.save(directory)
    }
}