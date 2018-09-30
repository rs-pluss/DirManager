package io.spring.dirmanager.service

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service

@Service
class AttachmentService(val jdbcTemplate: JdbcTemplate) {

//    /**
//     * Return all attachment of directoryRepository
//     */
//    fun getAllAttachments(): List<Attachment> {
//        return attachmentRepository.findAll().toMutableList()
//    }
//
//    fun save(attachment: Attachment) {
//        attachmentRepository.save(attachment)
//    }

}