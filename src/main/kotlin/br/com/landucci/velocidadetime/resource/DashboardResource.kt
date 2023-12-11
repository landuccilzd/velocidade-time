package br.com.clouzada.velocidadetime.resource

import br.com.clouzada.velocidadetime.model.command.DashboardCommand
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class DashboardResource {

    @GetMapping
    fun dashboard(): DashboardCommand {
        return DashboardCommand("API para gestão de time")
    }
}