package br.com.clouzada.velocidadetime.service.impl

import br.com.clouzada.velocidadetime.exception.GestaoTimeNotFoundException
import br.com.clouzada.velocidadetime.exception.GestaoTimeRNException
import br.com.clouzada.velocidadetime.model.Alocacao
import br.com.clouzada.velocidadetime.model.repository.AlocacaoRepository
import br.com.clouzada.velocidadetime.service.AlocacaoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AlocacaoServiceImpl @Autowired constructor(
    private val repository: AlocacaoRepository
) : AlocacaoService {

    override fun listar(): List<Alocacao> {
        val alocacaoList = this.repository.findAll().toList()
        if (alocacaoList.isEmpty()) {
            throw GestaoTimeNotFoundException("Nenhuma alocação encontrada")
        }
        return alocacaoList
    }

    override fun buscar(id: Long): Alocacao {
        val oPi = this.repository.findById(id)
        if (!oPi.isPresent) {
            throw GestaoTimeNotFoundException("A alocação com o id $id não foi encontrada")
        }

        return oPi.get()
    }

    override fun inserir(alocacao: Alocacao): Alocacao {
        return this.repository.save(alocacao)
    }

    override fun alterar(alocacao: Alocacao): Alocacao {
        return this.repository.save(alocacao)
    }

    override fun excluir(id: Long) {
        excluir(buscar(id))
    }

    override fun excluir(alocacao: Alocacao) {
        this.repository.delete(alocacao)
    }

    override fun validarAlocacao(recursoId: Long, iteracaoId: Long) {
        val alocacoesRecursoAlocacao = repository.findAllByRecurso_IdAndIteracao_Id(recursoId, iteracaoId)
        if (alocacoesRecursoAlocacao.isNotEmpty()) {
            throw GestaoTimeRNException("O recurso informado já está alocado nesta iteração")
        }
    }
}