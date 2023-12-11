package br.com.landucci.velocidadetime.service.impl

import br.com.landucci.velocidadetime.model.Recurso
import br.com.landucci.velocidadetime.exception.GestaoTimeNotFoundException
import br.com.landucci.velocidadetime.model.repository.RecursoRepository
import br.com.landucci.velocidadetime.service.RecursoService
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