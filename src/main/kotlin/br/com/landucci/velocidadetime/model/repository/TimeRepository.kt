package br.com.landucci.velocidadetime.model.repository

import br.com.landucci.velocidadetime.model.Time
import org.springframework.data.repository.CrudRepository

interface TimeRepository: CrudRepository<Time, Long> {
}