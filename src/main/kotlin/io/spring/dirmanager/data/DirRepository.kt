package io.spring.dirmanager.data

import org.springframework.data.repository.CrudRepository

interface DirRepository : CrudRepository<io.spring.dirmanager.catalog.structure.Directory, Long> {
}