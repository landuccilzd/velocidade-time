package br.com.landucci.velocidadetime.model.repository

import br.com.landucci.velocidadetime.model.Iteracao
import org.springframework.data.repository.CrudRepository

interface IteracaoRepository: CrudRepository<Iteracao, Long> {
}