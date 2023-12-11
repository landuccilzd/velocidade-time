package br.com.clouzada.velocidadetime.model

import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*

@Entity
@Table(name = "alocacao")
data class Alocacao(

    @ManyToOne
    @JoinColumn(name = "recurso_id")
    val recurso: Recurso,

    @ManyToOne
    @JoinColumn(name = "time_id")
    val time: Time,

    @ManyToOne
    @JoinColumn(name = "papel_id")
    val papel: Papel,

    @ManyToOne
    @JoinColumn(name = "iteracao_id")
    @JsonBackReference
    var iteracao: Iteracao,

    var diasFerias: Double = 0.0,
    var diasAusencia: Double = 0.0,
    var observacoes: String? = ""
) {

    init {
        repontuar()
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id = 0L

    var totalPontos = 0.0
        private set

    var totalHoras = 0.0
        private set

    private fun repontuar() {
        if (this.iteracao.iteracaoProdutiva == 0) {
            return
        }

        this.totalPontos = this.papel.pontuacao *
                (this.iteracao.diasIteracao - this.iteracao.diasFeriado - this.diasFerias - this.diasAusencia)
        this.totalHoras = (8 * this.time.fatorAjuste) * this.totalPontos
    }

}
