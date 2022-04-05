package br.produto.categoria.produtoapi.exceptions;

public class ProdutoNotFoundException extends RuntimeException {

    public ProdutoNotFoundException(Long id) {
        super(String.format("Produto de id %d não encontrado.", id));
    }

}
