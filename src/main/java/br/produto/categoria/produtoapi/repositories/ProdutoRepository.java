package br.produto.categoria.produtoapi.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import br.produto.categoria.produtoapi.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    static final String SQL = "SELECT new br.produto.categoria.produtoapi.repositories.ProdutoCategoriaDto(p.id, p.nome, p.codigo, p.valor, c.id, c.nome) FROM Produto p INNER JOIN p.categoria c";
    
    @Query(
        value = ProdutoRepository.SQL
    )
    List<ProdutoCategoriaDto> findAllWithCategoria();

    @Query(
        value = ProdutoRepository.SQL + " WHERE p.id = :id"
    )
    Optional<ProdutoCategoriaDto> findByIdWithCategoria(Long id);

}
