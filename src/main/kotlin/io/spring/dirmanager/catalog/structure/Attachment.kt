package io.spring.dirmanager.catalog.structure

import javax.persistence.*


/**
 * Entity class of content in the base directory
 *
 * @author rs-pluss
 */
@Entity
@Table(name = "attachment_t")
class Attachment {
    @Id
    @GeneratedValue
    var id: Long = 0
    /**
     * name of content
     */
    var name: String = ""

    /**
     * Content size
     */
    var size: Long = 0

    /**
     * content is directory (if false then content is file)
     */

    var isDirectory: Boolean = false

    /**
     * Relation with parent directory
     */
    @ManyToOne
    @JoinColumn(name = "directory_id")
    lateinit var directory: Directory

    /**
     * Content is file
     */
    fun isFile() = !isDirectory
}
