package br.com.clouzada.velocidadetime.resource

import br.com.clouzada.velocidadetime.model.Recurso
import br.com.clouzada.velocidadetime.service.impl.RecursoServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/recurso")
class RecursoResource @Autowired constructor(private val service: RecursoServiceImpl) {

    @GetMapping
    fun listar(): List<Recurso> {
        return this.service.listar()
    }

    @GetMapping("/{id}")
    fun buscar(@PathVariable("id") id: Long): Recurso {
        return this.service.buscar(id)
    }

    @PostMapping
    fun inserir(@RequestBody recurso: Recurso): Recurso {
        return this.service.inserir(recurso)
    }

    @PutMapping
    fun alterar(@RequestBody recurso: Recurso): Recurso {
        return this.service.alterar(recurso)
    }

    @DeleteMapping("/{id}")
    fun excluir(@PathVariable("id") id: Long) {
        this.service.excluir(id)
    }
}