package br.produto.categoria.produtoapi.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.produto.categoria.produtoapi.entities.Categoria;
import br.produto.categoria.produtoapi.exceptions.CategoriaNotFoundException;
import br.produto.categoria.produtoapi.exceptions.CategoriaOcupadaException;
import br.produto.categoria.produtoapi.repositories.CategoriaRepository;
import br.produto.categoria.produtoapi.services.interfaces.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private CategoriaRepository categoriaRepository;

    CategoriaServiceImpl (CategoriaRepository categoriaController) {
        this.categoriaRepository = categoriaController;
    }

    @Override
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria findOne(Long id) {
        return this.categoriaRepository.findById(id)
            .orElseThrow(() -> new CategoriaNotFoundException(id));
    }

    @Override
    public void deleteCategoria(Long id) {
        Boolean isUtilizadaPorProduto = this.categoriaRepository.existeProdutoCategoria(id) > 0;
        if (isUtilizadaPorProduto) throw new CategoriaOcupadaException(id);

        if (!this.categoriaRepository.existsById(id)) throw new CategoriaNotFoundException(id);
        this.categoriaRepository.deleteById(id);
        
    }

    @Override
    public Categoria save(CategoriaDto dto) {
        return this.categoriaRepository.save(dto.toCategoria());
    }

    @Override
    public Categoria updCategoria(CategoriaDto dto, Long id) {
        return this.categoriaRepository.findById(id)
            .map(c -> {
                c.setDescricao(dto.getDescricao());
                c.setNome(dto.getNome());
                return this.categoriaRepository.save(c);
            })
            .orElseThrow(() -> new CategoriaNotFoundException(id));
    }
    
}
