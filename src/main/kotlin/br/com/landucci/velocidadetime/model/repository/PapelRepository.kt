package br.com.landucci.velocidadetime.model.repository

import br.com.landucci.velocidadetime.model.Papel
import org.springframework.data.repository.CrudRepository

interface PapelRepository: CrudRepository<Papel, Long> {
}