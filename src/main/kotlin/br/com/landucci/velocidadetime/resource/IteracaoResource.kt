package br.com.landucci.velocidadetime.resource

import br.com.landucci.velocidadetime.model.Iteracao
import br.com.landucci.velocidadetime.model.command.AlocacaoCommand
import br.com.landucci.velocidadetime.service.impl.IteracaoServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/iteracao")
class IteracaoResource @Autowired constructor(private val service: IteracaoServiceImpl) {

    @GetMapping
    fun listar(): List<Iteracao> {
        return this.service.listar()
    }

    @GetMapping("/{id}")
    fun buscar(@PathVariable("id") id: Long): Iteracao {
        return this.service.buscar(id)
    }

    @PostMapping
    fun inserir(@RequestBody iteracao: Iteracao): Iteracao {
        return this.service.inserir(iteracao)
    }

    @PutMapping
    fun alterar(@RequestBody iteracao: Iteracao): Iteracao {
        return this.service.alterar(iteracao)
    }

    @DeleteMapping("/{id}")
    fun excluir(@PathVariable("id") id: Long) {
        this.service.excluir(id)
    }

    @PutMapping("/alocar/{id}")
    fun alocar(@PathVariable("id") id: Long, @RequestBody alocacaoCommand: AlocacaoCommand): Iteracao {
        return this.service.alocar(id, alocacaoCommand)
    }
}