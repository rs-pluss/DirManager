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

    lateinit var date: Date

    /**
     * List of content in directory
     */
    @OneToMany(mappedBy = "directory")
    lateinit var attachments: List<Attachment>

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
     * @return count of including files
     */
    fun getInnerFilesCount(): Int {
        return attachments.filter { it.isFile() }.size
    }

    /**
     * Return count of directories in directory
     * @return count of including directories
     */
    fun getInnerDirectoriesCount(): Int {
        return attachments.filter { it.isDirectory }.size
    }
}