package br.com.landucci.velocidadetime.service

import br.com.landucci.velocidadetime.model.Time

interface TimeService {
    fun listar(): List<Time>
    fun buscar(id: Long): Time
    fun inserir(time: Time): Time
    fun alterar(time: Time): Time
    fun excluir(id: Long)
    fun excluir(time: Time)
}