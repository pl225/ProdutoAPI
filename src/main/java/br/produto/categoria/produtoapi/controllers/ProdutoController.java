package br.produto.categoria.produtoapi.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.produto.categoria.produtoapi.entities.Produto;
import br.produto.categoria.produtoapi.services.ProdutoDto;
import br.produto.categoria.produtoapi.services.interfaces.ProdutoService;

@RestController
public class ProdutoController {

    private final ProdutoService produtoService;

    ProdutoController (ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping("/produtos")
    List<Produto> all() {
        return this.produtoService.all();
    }

    @GetMapping("/produtos/{id}")
    Produto findOne(@PathVariable Long id) {
        return this.produtoService.findOne(id);
    }

    @DeleteMapping("/produtos/{id}")
    void deleteProduto(@PathVariable Long id) {
        this.produtoService.deleteProduto(id);
    }

    @PostMapping("/produtos")
    Produto save(@Valid @RequestBody ProdutoDto dto) {
        return this.produtoService.save(dto);
    }

    @PutMapping("/produtos/{id}")
    Produto updProduto(@Valid @RequestBody ProdutoDto dto, @PathVariable Long id) {
        return this.produtoService.updProduto(dto, id);
    }
    
}
