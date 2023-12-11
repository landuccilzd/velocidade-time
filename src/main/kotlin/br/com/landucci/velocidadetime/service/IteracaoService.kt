package br.com.landucci.velocidadetime.service

import br.com.landucci.velocidadetime.model.Iteracao
import br.com.landucci.velocidadetime.model.command.AlocacaoCommand

interface IteracaoService {
    fun listar(): List<Iteracao>
    fun buscar(id: Long): Iteracao
    fun inserir(iteracao: Iteracao): Iteracao
    fun alterar(iteracao: Iteracao): Iteracao
    fun excluir(id: Long)
    fun excluir(iteracao: Iteracao)
    fun alocar(id: Long, alocacaoCommand: AlocacaoCommand): Iteracao
}