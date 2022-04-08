package br.produto.categoria.produtoapi.services.interfaces;

import java.util.List;

import br.produto.categoria.produtoapi.entities.Categoria;
import br.produto.categoria.produtoapi.services.CategoriaDto;

public interface CategoriaService {

    List<Categoria> findAll();

    Categoria findOne(Long id);

    void deleteCategoria(Long id);

    Categoria save(CategoriaDto dto);

    Categoria updCategoria(CategoriaDto dto, Long id);

}