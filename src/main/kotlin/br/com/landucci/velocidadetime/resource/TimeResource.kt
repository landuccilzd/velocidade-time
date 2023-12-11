package br.com.landucci.velocidadetime.resource

import br.com.landucci.velocidadetime.model.Time
import br.com.landucci.velocidadetime.service.impl.TimeServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/time")
class TimeResource @Autowired constructor(private val service: TimeServiceImpl) {

    @GetMapping
    fun listar(): List<Time> {
        return this.service.listar()
    }

    @GetMapping("/{id}")
    fun buscar(@PathVariable("id") id: Long): Time {
        return this.service.buscar(id)
    }

    @PostMapping
    fun inserir(@RequestBody time: Time): Time {
        return this.service.inserir(time)
    }

    @PutMapping
    fun alterar(@RequestBody time: Time): Time {
        return this.service.alterar(time)
    }

    @DeleteMapping("/{id}")
    fun excluir(@PathVariable("id") id: Long) {
        this.service.excluir(id)
    }
}