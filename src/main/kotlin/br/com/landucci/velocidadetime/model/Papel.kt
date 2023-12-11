package br.com.clouzada.velocidadetime.model

import javax.persistence.*

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
