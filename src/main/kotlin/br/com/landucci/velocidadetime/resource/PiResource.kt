package br.com.clouzada.velocidadetime.resource

import br.com.clouzada.velocidadetime.model.Pi
import br.com.clouzada.velocidadetime.service.impl.PiServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/pi")
class PiResource @Autowired constructor(private val service: PiServiceImpl) {

    @GetMapping
    fun listar(): List<Pi> {
        return this.service.listar()
    }

    @GetMapping("/{id}")
    fun buscar(@PathVariable("id") id: Long): Pi {
        return this.service.buscar(id)
    }

    @PostMapping
    fun inserir(@RequestBody pi: Pi): Pi {
        return this.service.inserir(pi)
    }

    @PutMapping
    fun alterar(@RequestBody pi: Pi): Pi {
        return this.service.alterar(pi)
    }

    @DeleteMapping("/{id}")
    fun excluir(@PathVariable("id") id: Long) {
        this.service.excluir(id)
    }
}