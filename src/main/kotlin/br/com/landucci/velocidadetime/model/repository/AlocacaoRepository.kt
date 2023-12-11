package br.com.landucci.velocidadetime.model.repository

import br.com.landucci.velocidadetime.model.Alocacao
import org.springframework.data.repository.CrudRepository

interface AlocacaoRepository: CrudRepository<Alocacao, Long> {

    fun findAllByRecurso_IdAndIteracao_Id(recursoId: Long, iteracaoId: Long): List<Alocacao>
}