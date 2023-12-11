package br.com.clouzada.velocidadetime.model.repository

import br.com.clouzada.velocidadetime.model.Iteracao
import org.springframework.data.repository.CrudRepository

interface IteracaoRepository: CrudRepository<Iteracao, Long> {
}