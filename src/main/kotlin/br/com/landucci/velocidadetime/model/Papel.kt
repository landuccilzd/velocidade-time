package br.com.landucci.velocidadetime.model

import jakarta.persistence.*

@Entity
@Table(name = "papel")
data class Papel(
    val nome: String,
    val pontuacao: Double
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id = 0L
}
