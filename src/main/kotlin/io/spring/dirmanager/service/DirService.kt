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
    fun getDirectoryById(id: Long): Directory {
        return directoryRepository.findById(id).get()
    }
    
    fun obtainDirectorynAttachment(id:Long):Set<Attachment> {
        return getDirectoryById(id).attachments
    }
    /**
     * Create directory by the path and add them to repository
     */
    fun addNewDirectory(path: String) {
        val folder = File(path)
        val directory = Directory()
        directory.name = path
        directory.date = Date()
        //TODO investigate how save directory once time
        directoryRepository.save(directory)
        for (file in folder.listFiles()) {
            val attachment = Attachment()
            attachment.name = file.name
            attachment.size =
                    if (file.isDirectory) FileUtils.sizeOfDirectory(file) else file.length()
            attachment.isDirectory = file.isDirectory
            attachment.directory = directory
            directory.addAttachment(attachment)
            attachmentRepository.save(attachment)
        }
        directoryRepository.save(directory)
    }
}