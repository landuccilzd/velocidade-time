package br.com.landucci.velocidadetime.service

import br.com.landucci.velocidadetime.model.Pi

interface PiService {
    fun listar(): List<Pi>
    fun buscar(id: Long): Pi
    fun inserir(pi: Pi): Pi
    fun alterar(pi: Pi): Pi
    fun excluir(id: Long)
    fun excluir(pi: Pi)
    fun recalcular(pi: Pi)
}