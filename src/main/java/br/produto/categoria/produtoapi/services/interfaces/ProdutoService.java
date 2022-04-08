package br.produto.categoria.produtoapi.services.interfaces;

import java.util.List;

import br.produto.categoria.produtoapi.entities.Produto;
import br.produto.categoria.produtoapi.services.ProdutoDto;

public interface ProdutoService {
    
    List<Produto> all();

    Produto findOne(Long id);

    void deleteProduto(Long id);

    Produto save(ProdutoDto dto);

    Produto updProduto(ProdutoDto dto, Long id);

}
