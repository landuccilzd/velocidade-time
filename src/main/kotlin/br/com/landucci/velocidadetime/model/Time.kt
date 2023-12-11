package br.com.clouzada.velocidadetime.model

import javax.persistence.*

@Entity
@Table(name = "time")
data class Time(
    val nome: String,
    val sigla: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id = 0L
    var logo = ""
        get() {
            if (field == null || field.isEmpty()) {
                return "letras/${this.nome.substring(0, 1).toLowerCase()}.jpg"
            }
            return field
        }

    var fatorAjuste = 0.0
        private set

    fun nomeResumido(): String {
        if (this.nome.indexOf(" ") > 0) {
            return "${this.nome.substring(0, 1)}. ${this.nome.substring(this.nome.lastIndexOf(" ") + 1)}"
        }
        return this.nome
    }
}
