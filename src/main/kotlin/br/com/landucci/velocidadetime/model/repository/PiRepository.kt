package br.com.clouzada.velocidadetime.model.repository

import br.com.clouzada.velocidadetime.model.Pi
import org.springframework.data.repository.CrudRepository

interface PiRepository: CrudRepository<Pi, Long> {
}