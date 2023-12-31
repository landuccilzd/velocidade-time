package br.com.landucci.velocidadetime.service

import br.com.landucci.velocidadetime.model.Alocacao

interface AlocacaoService {
    fun listar(): List<Alocacao>
    fun buscar(id: Long): Alocacao
    fun inserir(alocacao: Alocacao): Alocacao
    fun alterar(alocacao: Alocacao): Alocacao
    fun excluir(id: Long)
    fun excluir(alocacao: Alocacao)
    fun validarAlocacao(recursoId: Long, iteracaoId: Long)
}