package br.com.clouzada.velocidadetime.model.command

data class AlocacaoCommand(
    val recursoId: Long,
    val timeId: Long,
    val papelId: Long,
    val totalPontos: Double,
    val totalHoras: Double,
    val diasFerias: Double,
    val diasAusencia: Double,
    val observacoes: String?
)