package br.com.landucci.velocidadetime.model.repository

import br.com.landucci.velocidadetime.model.Recurso
import org.springframework.data.repository.CrudRepository

interface RecursoRepository: CrudRepository<Recurso, Long> {
}