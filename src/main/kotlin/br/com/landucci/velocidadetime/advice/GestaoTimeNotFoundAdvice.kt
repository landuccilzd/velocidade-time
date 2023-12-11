package br.com.clouzada.velocidadetime.advice

import br.com.clouzada.velocidadetime.exception.GestaoTimeNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus

@ControllerAdvice
class GestaoTimeNotFoundAdvice {
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(GestaoTimeNotFoundException::class)
    fun gestaoTimeNotFoundHandler(e: GestaoTimeNotFoundException): String? {
        return e.message
    }
}