package br.com.clouzada.velocidadetime.service

import br.com.clouzada.velocidadetime.model.Papel

interface PapelService {
    fun listar(): List<Papel>
    fun buscar(id: Long): Papel
    fun inserir(papel: Papel): Papel
    fun alterar(papel: Papel): Papel
    fun excluir(id: Long)
    fun excluir(papel: Papel)
}