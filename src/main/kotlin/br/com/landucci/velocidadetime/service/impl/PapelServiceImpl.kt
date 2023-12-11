package br.com.clouzada.velocidadetime.service.impl

import br.com.clouzada.velocidadetime.exception.GestaoTimeNotFoundException
import br.com.clouzada.velocidadetime.model.Papel
import br.com.clouzada.velocidadetime.model.repository.PapelRepository
import br.com.clouzada.velocidadetime.service.PapelService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PapelServiceImpl @Autowired constructor(private val repository: PapelRepository): PapelService {

    override fun listar(): List<Papel> {
        return this.repository.findAll().toList()
    }

    override fun buscar(id: Long): Papel {
        val oPi = this.repository.findById(id)
        if (!oPi.isPresent) {
            throw GestaoTimeNotFoundException("O PI com o id $id não foi encontrado")
        }

        return oPi.get()
    }

    override fun inserir(papel: Papel): Papel {
        return this.repository.save(papel)
    }

    override fun alterar(papel: Papel): Papel {
        return this.repository.save(papel)
    }

    override fun excluir(id: Long) {
        excluir(buscar(id))
    }

    override fun excluir(papel: Papel) {
        this.repository.delete(papel)
    }
}