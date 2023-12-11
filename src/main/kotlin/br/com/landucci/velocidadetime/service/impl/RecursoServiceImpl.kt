package br.com.clouzada.velocidadetime.service.impl

import br.com.clouzada.velocidadetime.model.Recurso
import br.com.clouzada.velocidadetime.exception.GestaoTimeNotFoundException
import br.com.clouzada.velocidadetime.model.repository.RecursoRepository
import br.com.clouzada.velocidadetime.service.RecursoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RecursoServiceImpl @Autowired constructor(private val repository: RecursoRepository): RecursoService {

    override fun listar(): List<Recurso> {
        return this.repository.findAll().toList()
    }

    override fun buscar(id: Long): Recurso {
        val oRecurso = this.repository.findById(id)
        if (!oRecurso.isPresent) {
            throw GestaoTimeNotFoundException("O recurso com o id $id não foi encontrado")
        }

        return oRecurso.get()
    }

    override fun inserir(recurso: Recurso): Recurso {
        return this.repository.save(recurso)
    }

    override fun alterar(recurso: Recurso): Recurso {
        return this.repository.save(recurso)
    }

    override fun excluir(id: Long) {
        excluir(buscar(id))
    }

    override fun excluir(recurso: Recurso) {
        this.repository.delete(recurso)
    }
}