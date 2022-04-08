package br.produto.categoria.produtoapi.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.produto.categoria.produtoapi.entities.Categoria;
import br.produto.categoria.produtoapi.entities.Produto;
import br.produto.categoria.produtoapi.exceptions.ProdutoNotFoundException;
import br.produto.categoria.produtoapi.repositories.ProdutoRepository;
import br.produto.categoria.produtoapi.services.interfaces.CategoriaService;
import br.produto.categoria.produtoapi.services.interfaces.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private ProdutoRepository produtoRepository;
    private CategoriaService categoriaService;

    ProdutoServiceImpl (ProdutoRepository produtoRepository, CategoriaService categoriaService) {
        this.produtoRepository = produtoRepository;
        this.categoriaService = categoriaService;
    }

    private Categoria getCategoria(Long id) {
        return this.categoriaService.findOne(id);
    }

    @Override
    public List<Produto> all() {
        return this.produtoRepository.findAll();
    }

    @Override
    public Produto findOne(Long id) {
        return this.produtoRepository.findById(id)
            .orElseThrow(() -> new ProdutoNotFoundException(id));
    }

    @Override
    public void deleteProduto(Long id) {
        if (!this.produtoRepository.existsById(id)) throw new ProdutoNotFoundException(id);
        this.produtoRepository.deleteById(id);
        
    }

    @Override
    public Produto save(ProdutoDto dto) {
        Categoria categoria = this.getCategoria(dto.getCategoriaId());
        return this.produtoRepository.save(dto.toProduto(categoria));
    }

    @Override
    public Produto updProduto(ProdutoDto dto, Long id) {
        Categoria categoria = this.getCategoria(dto.getCategoriaId());
        
        return this.produtoRepository.findById(id)
            .map(p -> {
                p.setCodigo(dto.getCodigo());
                p.setNome(dto.getNome());
                p.setValor(dto.getValor());
                p.setCategoria(categoria);

                return this.produtoRepository.save(p);
            })
            .orElseThrow(() -> new ProdutoNotFoundException(id));
    }
    
}
