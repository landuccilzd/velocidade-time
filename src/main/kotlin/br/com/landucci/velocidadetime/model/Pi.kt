package br.com.clouzada.velocidadetime.model

import com.fasterxml.jackson.annotation.JsonBackReference
import org.hibernate.annotations.Cascade
import org.hibernate.annotations.CascadeType
import javax.persistence.*

@Entity
@Table(name = "pi")
data class Pi(
    val nome: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id = 0L

    var totalPontos = 0.0
        private set

    var totalHoras = 0.0
        private set

    @OneToMany(mappedBy = "pi")
    @Cascade(CascadeType.ALL)
    private var iteracaoList = mutableListOf<Iteracao>()
    val iteracoes: Collection<Iteracao>
        get() {
            return iteracaoList.toList()
        }

    fun adicionarIteracao(iteracao: Iteracao) {
        this.iteracaoList.add(iteracao)
    }

    fun repontuar() {
        this.totalPontos = 0.0
        this.totalHoras = 0.0
        this.iteracaoList.forEach { iteracao ->
            this.totalPontos += iteracao.totalPontos
            this.totalHoras += iteracao.totalHoras
        }
    }
}