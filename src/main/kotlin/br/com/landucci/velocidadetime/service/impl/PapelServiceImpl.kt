package br.com.landucci.velocidadetime.service.impl

import br.com.landucci.velocidadetime.exception.GestaoTimeNotFoundException
import br.com.landucci.velocidadetime.model.Papel
import br.com.landucci.velocidadetime.model.repository.PapelRepository
import br.com.landucci.velocidadetime.service.PapelService
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