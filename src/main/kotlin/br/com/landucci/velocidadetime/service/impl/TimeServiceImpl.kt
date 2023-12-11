package br.com.clouzada.velocidadetime.service.impl

import br.com.clouzada.velocidadetime.exception.GestaoTimeNotFoundException
import br.com.clouzada.velocidadetime.model.Time
import br.com.clouzada.velocidadetime.model.repository.TimeRepository
import br.com.clouzada.velocidadetime.service.TimeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TimeServiceImpl @Autowired constructor(private val repository: TimeRepository): TimeService {

    override fun listar(): List<Time> {
        return this.repository.findAll().toList()
    }

    override fun buscar(id: Long): Time {
        val oTime = this.repository.findById(id)
        if (!oTime.isPresent) {
            throw GestaoTimeNotFoundException("O time com o id $id não foi encontrado")
        }

        return oTime.get()
    }

    override fun inserir(time: Time): Time {
        return this.repository.save(time)
    }

    override fun alterar(time: Time): Time {
        return this.repository.save(time)
    }

    override fun excluir(id: Long) {
        excluir(buscar(id))
    }

    override fun excluir(time: Time) {
        this.repository.delete(time)
    }
}