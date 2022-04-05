package br.produto.categoria.produtoapi.exceptions;

public class CategoriaOcupadaException extends RuntimeException {
    public CategoriaOcupadaException(Long id) {
        super(String.format("Categoria de id %d está sendo usada por algum produto e não pode ser excluída.", id));
    }
}
