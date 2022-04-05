package br.produto.categoria.produtoapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.produto.categoria.produtoapi.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    
    @Query(
        value = "SELECT COUNT(c.id) FROM categoria c INNER JOIN produto p ON p.categoria_id = c.id WHERE c.id = ?1",
        nativeQuery = true
    )
    Long existeProdutoCategoria(Long categoriaId);

}
