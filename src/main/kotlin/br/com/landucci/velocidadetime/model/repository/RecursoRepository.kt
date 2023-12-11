package br.com.clouzada.velocidadetime.model.repository

import br.com.clouzada.velocidadetime.model.Recurso
import org.springframework.data.repository.CrudRepository

interface RecursoRepository: CrudRepository<Recurso, Long> {
}