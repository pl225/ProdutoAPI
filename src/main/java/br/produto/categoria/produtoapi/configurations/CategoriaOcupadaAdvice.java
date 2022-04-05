package br.produto.categoria.produtoapi.configurations;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.produto.categoria.produtoapi.exceptions.CategoriaOcupadaException;

@ControllerAdvice
class CategoriaOcupadaAdvice {

    @ResponseBody
    @ExceptionHandler(CategoriaOcupadaException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String categoriaOcupadaHandler(CategoriaOcupadaException exception) {
        return exception.getMessage();
    }

}