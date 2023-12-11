package br.com.clouzada.velocidadetime.resource

import br.com.clouzada.velocidadetime.model.Papel
import br.com.clouzada.velocidadetime.service.impl.PapelServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/papel")
class PapelResource @Autowired constructor(private val service: PapelServiceImpl) {

    @GetMapping
    fun listar(): List<Papel> {
        return this.service.listar()
    }

    @GetMapping("/{id}")
    fun buscar(@PathVariable("id") id: Long): Papel {
        return this.service.buscar(id)
    }

    @PostMapping
    fun inserir(@RequestBody papel: Papel): Papel {
        return this.service.inserir(papel)
    }

    @PutMapping
    fun alterar(@RequestBody papel: Papel): Papel {
        return this.service.alterar(papel)
    }

    @DeleteMapping("/{id}")
    fun excluir(@PathVariable("id") id: Long) {
        this.service.excluir(id)
    }
}