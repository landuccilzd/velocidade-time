package br.com.clouzada.velocidadetime.service

import br.com.clouzada.velocidadetime.model.Recurso

interface RecursoService {
    fun listar(): List<Recurso>
    fun buscar(id: Long): Recurso
    fun inserir(recurso: Recurso): Recurso
    fun alterar(recurso: Recurso): Recurso
    fun excluir(id: Long)
    fun excluir(recurso: Recurso)
}