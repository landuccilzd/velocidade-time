package br.com.clouzada.velocidadetime.service.impl

import br.com.clouzada.velocidadetime.exception.GestaoTimeNotFoundException
import br.com.clouzada.velocidadetime.model.Alocacao
import br.com.clouzada.velocidadetime.model.Iteracao
import br.com.clouzada.velocidadetime.model.command.AlocacaoCommand
import br.com.clouzada.velocidadetime.model.repository.IteracaoRepository
import br.com.clouzada.velocidadetime.service.IteracaoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class IteracaoServiceImpl @Autowired constructor(
    private val repository: IteracaoRepository,
    private val recursoService: RecursoServiceImpl,
    private val timeService: TimeServiceImpl,
    private val papelService: PapelServiceImpl,
    private val piService: PiServiceImpl,
    private val alocacaoService: AlocacaoServiceImpl
) : IteracaoService {

    override fun listar(): List<Iteracao> {
        return this.repository.findAll().toList()
    }

    override fun buscar(id: Long): Iteracao {
        val oPi = this.repository.findById(id)
        if (!oPi.isPresent) {
            throw GestaoTimeNotFoundException("A iteração com o id $id não foi encontrada")
        }

        return oPi.get()
    }

    override fun inserir(iteracao: Iteracao): Iteracao {
        return this.repository.save(iteracao)
    }

    override fun alterar(iteracao: Iteracao): Iteracao {
        return this.repository.save(iteracao)
    }

    override fun excluir(id: Long) {
        excluir(buscar(id))
    }

    override fun excluir(iteracao: Iteracao) {
        this.repository.delete(iteracao)
    }

    override fun alocar(id: Long, alocacaoCommand: AlocacaoCommand): Iteracao {
        this.alocacaoService.validarAlocacao(alocacaoCommand.recursoId, id)

        val iteracao = buscar(id)
        val alocacao = Alocacao(
            recurso = recursoService.buscar(alocacaoCommand.recursoId),
            time = timeService.buscar(alocacaoCommand.timeId),
            papel = papelService.buscar(alocacaoCommand.papelId),
            iteracao = iteracao,
            diasFerias = alocacaoCommand.diasFerias,
            diasAusencia = alocacaoCommand.diasAusencia,
            observacoes = alocacaoCommand.observacoes
        )
        iteracao.alocar(alocacao)
        piService.recalcular(iteracao.pi)
        return alterar(iteracao)
    }
}