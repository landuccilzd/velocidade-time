package br.com.landucci.velocidadetime.model.repository

import br.com.landucci.velocidadetime.model.Pi
import org.springframework.data.repository.CrudRepository

interface PiRepository: CrudRepository<Pi, Long> {
}