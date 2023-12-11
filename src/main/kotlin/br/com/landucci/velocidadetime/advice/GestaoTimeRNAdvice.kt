package br.com.clouzada.velocidadetime.advice

import br.com.clouzada.velocidadetime.exception.GestaoTimeRNException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus

@ControllerAdvice
class GestaoTimeRNAdvice {

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(GestaoTimeRNException::class)
    fun gestaoTimeRNHandler(e: GestaoTimeRNException): String? {
        return e.message
    }
}