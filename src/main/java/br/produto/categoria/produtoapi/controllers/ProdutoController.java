package br.produto.categoria.produtoapi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.produto.categoria.produtoapi.entities.Categoria;
import br.produto.categoria.produtoapi.entities.Produto;
import br.produto.categoria.produtoapi.exceptions.CategoriaNotFoundException;
import br.produto.categoria.produtoapi.exceptions.ProdutoNotFoundException;
import br.produto.categoria.produtoapi.repositories.CategoriaRepository;
import br.produto.categoria.produtoapi.repositories.ProdutoCategoriaDto;
import br.produto.categoria.produtoapi.repositories.ProdutoRepository;

@RestController
public class ProdutoController {

    private final ProdutoRepository produtoRepository;
    private final CategoriaRepository categoriaRepository;

    ProdutoController (ProdutoRepository produtoRepository, CategoriaRepository categoriaRepository) {
        this.produtoRepository = produtoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    private Categoria getCategoria(Long id) {
        return this.categoriaRepository.findById(id)
            .orElseThrow(() -> new CategoriaNotFoundException(id));
    }

    @GetMapping("/produtos")
    List<ProdutoCategoriaDto> all() {
        return this.produtoRepository.findAllWithCategoria();
    }

    @GetMapping("/produtos/{id}")
    Produto findOne(@PathVariable Long id) {
        return this.produtoRepository.findById(id)
            .orElseThrow(() -> new ProdutoNotFoundException(id));
    }

    @DeleteMapping("/produtos/{id}")
    void deleteProduto(@PathVariable Long id) {
        if (!this.produtoRepository.existsById(id)) throw new ProdutoNotFoundException(id);
        this.produtoRepository.deleteById(id);
    }

    @PostMapping("/produtos")
    Produto save(@RequestBody ProdutoDto dto) {
        Categoria categoria = this.getCategoria(dto.getCategoriaId());
        return this.produtoRepository.save(dto.toProduto(categoria));
    }

    @PutMapping("/produtos/{id}")
    Produto updProduto(@RequestBody ProdutoDto dto, @PathVariable Long id) {
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
