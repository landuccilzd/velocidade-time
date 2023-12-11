package br.com.clouzada.velocidadetime.service

import br.com.clouzada.velocidadetime.model.Pi

interface PiService {
    fun listar(): List<Pi>
    fun buscar(id: Long): Pi
    fun inserir(pi: Pi): Pi
    fun alterar(pi: Pi): Pi
    fun excluir(id: Long)
    fun excluir(pi: Pi)
    fun recalcular(pi: Pi)
}