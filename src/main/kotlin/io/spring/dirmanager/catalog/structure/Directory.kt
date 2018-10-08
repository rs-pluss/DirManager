package io.spring.dirmanager.catalog.structure

import java.util.*
import javax.persistence.*

/**
 * Entity class for directories
 *
 * @author rs-pluss
 */
@Entity
@Table(name = "directory_t")
class Directory {
    @Id
    @GeneratedValue
    var id: Long = 0
    /**
     * Directory name
     */
    lateinit var name: String

    /**
     * Date of directory adding
     */
    lateinit var date: Date

    /**
     * List of content in directory
     */
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "directory", cascade = [(CascadeType.ALL)])
    val attachments = mutableSetOf<Attachment>()

    /**
     * Return size of directory
     */
    fun getSize(): Long {
        var totalSize = 0L
        for (attachment in attachments) {
            totalSize += attachment.size
        }
        return totalSize
    }

    /**
     *  Return count of files in directory
     */
    fun getInnerFilesCount(): Int {
        return attachments.filter { it.isFile() }.size
    }

    /**
     * Return count of directories in directory
     */
    fun getInnerDirectoriesCount(): Int {
        return attachments.filter { it.isDirectory }.size
    }

    /**
     * Add attachment to Directory
     */
    fun addAttachment(attachment: Attachment) {
        attachments.add(attachment)
    }
}