package br.produto.categoria.produtoapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import br.produto.categoria.produtoapi.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
