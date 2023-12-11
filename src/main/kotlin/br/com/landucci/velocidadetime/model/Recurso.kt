package br.com.clouzada.velocidadetime.model

import com.fasterxml.jackson.annotation.JsonFormat
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "recurso")
data class Recurso(
    val nome: String,

    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    val dataNascimento: Date
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id = 0L
    var apelido = ""
}
