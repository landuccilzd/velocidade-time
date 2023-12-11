package br.com.clouzada.velocidadetime.model.repository

import br.com.clouzada.velocidadetime.model.Papel
import org.springframework.data.repository.CrudRepository

interface PapelRepository: CrudRepository<Papel, Long> {
}