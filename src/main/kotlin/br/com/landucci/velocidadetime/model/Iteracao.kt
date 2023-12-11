package br.com.clouzada.velocidadetime.model

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonFormat
import org.hibernate.annotations.Cascade
import org.hibernate.annotations.CascadeType
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "iteracao")
data class Iteracao(
    val nome: String,

    @ManyToOne
    @JoinColumn(name = "pi_id")
    @JsonBackReference
    val pi: Pi,

    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    val dataInicio: Date,

    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    val dataTermino: Date,
    val iteracaoProdutiva: Int
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id = 0L

    var diasFeriado = 0
    var diasIteracao = 0
    var totalPontos = 0.0
        private set

    var totalHoras = 0.0
        private set

    @OneToMany(mappedBy = "iteracao")
    @Cascade(CascadeType.ALL)
    private val alocacoesList = mutableListOf<Alocacao>()
    val alocacoes: Collection<Alocacao>
        get() {
            return alocacoesList.toList()
        }

    fun alocar(alocacao: Alocacao) {
        this.alocacoesList.add(alocacao)
        this.repontuar()
        this.pi.repontuar()
    }

    private fun repontuar() {
        this.totalPontos = 0.0
        this.totalHoras = 0.0
        this.alocacoesList.forEach { alocacao ->
            this.totalPontos += alocacao.totalPontos
            this.totalHoras += alocacao.totalHoras
        }
    }
}
