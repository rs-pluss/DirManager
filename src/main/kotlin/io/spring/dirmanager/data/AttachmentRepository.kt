package io.spring.dirmanager.data

import io.spring.dirmanager.catalog.structure.Attachment
import org.springframework.data.repository.CrudRepository

interface AttachmentRepository : CrudRepository<Attachment, Long> {
}