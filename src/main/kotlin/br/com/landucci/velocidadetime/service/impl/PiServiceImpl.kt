package br.com.landucci.velocidadetime.service.impl

import br.com.landucci.velocidadetime.model.Pi
import br.com.landucci.velocidadetime.exception.GestaoTimeNotFoundException
import br.com.landucci.velocidadetime.model.repository.PiRepository
import br.com.landucci.velocidadetime.service.PiService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PiServiceImpl @Autowired constructor(private val repository: PiRepository): PiService {

    override fun listar(): List<Pi> {
        return this.repository.findAll().toList()
    }

    override fun buscar(id: Long): Pi {
        val oPi = this.repository.findById(id)
        if (!oPi.isPresent) {
            throw GestaoTimeNotFoundException("O PI com o id $id não foi encontrado")
        }

        return oPi.get()
    }

    override fun inserir(pi: Pi): Pi {
        return this.repository.save(pi)
    }

    override fun alterar(pi: Pi): Pi {
        return this.repository.save(pi)
    }

    override fun excluir(id: Long) {
        excluir(buscar(id))
    }

    override fun excluir(pi: Pi) {
        this.repository.delete(pi)
    }

    override fun recalcular(pi: Pi) {
        pi.repontuar()
        alterar(pi)
    }
}