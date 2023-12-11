package br.com.clouzada.velocidadetime.model.repository

import br.com.clouzada.velocidadetime.model.Time
import org.springframework.data.repository.CrudRepository

interface TimeRepository: CrudRepository<Time, Long> {
}