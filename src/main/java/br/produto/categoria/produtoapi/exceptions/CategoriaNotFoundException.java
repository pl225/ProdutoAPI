package br.produto.categoria.produtoapi.exceptions;

public class CategoriaNotFoundException extends RuntimeException {
    public CategoriaNotFoundException(Long id) {
        super(String.format("Categoria de id %d não encontrada.", id));
    }
}
