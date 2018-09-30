package io.spring.dirmanager.data

import io.spring.dirmanager.catalog.structure.Directory
import org.springframework.data.repository.CrudRepository

interface DirRepository : CrudRepository<Directory, Long> {
}