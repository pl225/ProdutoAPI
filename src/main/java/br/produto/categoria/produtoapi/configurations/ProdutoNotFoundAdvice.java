package br.produto.categoria.produtoapi.configurations;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.produto.categoria.produtoapi.exceptions.ProdutoNotFoundException;

@ControllerAdvice
class ProdutoNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(ProdutoNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String produtoNotFoundHandler(ProdutoNotFoundException exception) {
        return exception.getMessage();
    }

}