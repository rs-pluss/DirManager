package io.spring.DirManager.data

import org.springframework.data.repository.CrudRepository

interface DirRepository : CrudRepository<io.spring.DirManager.catalog.structure.Directory, Long> {
}