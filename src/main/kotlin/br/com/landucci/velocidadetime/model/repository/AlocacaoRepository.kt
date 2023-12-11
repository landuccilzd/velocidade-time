package br.com.clouzada.velocidadetime.model.repository

import br.com.clouzada.velocidadetime.model.Alocacao
import org.springframework.data.repository.CrudRepository

interface AlocacaoRepository: CrudRepository<Alocacao, Long> {

    fun findAllByRecurso_IdAndIteracao_Id(recursoId: Long, iteracaoId: Long): List<Alocacao>
}