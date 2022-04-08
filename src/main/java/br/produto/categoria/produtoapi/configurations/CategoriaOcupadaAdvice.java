package br.produto.categoria.produtoapi.configurations;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.produto.categoria.produtoapi.exceptions.CategoriaOcupadaException;

@ControllerAdvice
class CategoriaOcupadaAdvice {

    @ResponseBody
    @ExceptionHandler(CategoriaOcupadaException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<?> categoriaOcupadaHandler(CategoriaOcupadaException exception) {
        Map<String, String> body = new HashMap<>();

        body.put("message", exception.getMessage());

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

}