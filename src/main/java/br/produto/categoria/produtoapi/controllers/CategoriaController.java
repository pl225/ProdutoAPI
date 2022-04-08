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

import br.produto.categoria.produtoapi.entities.Categoria;
import br.produto.categoria.produtoapi.exceptions.CategoriaNotFoundException;
import br.produto.categoria.produtoapi.exceptions.CategoriaOcupadaException;
import br.produto.categoria.produtoapi.repositories.CategoriaRepository;

@RestController
public class CategoriaController {

    private final CategoriaRepository categoriaRepository;

    CategoriaController (CategoriaRepository categoriaController) {
        this.categoriaRepository = categoriaController;
    }

    @GetMapping("/categorias")
    List<Categoria> all() {
        return this.categoriaRepository.findAll();
    }

    @GetMapping("/categorias/{id}")
    Categoria findOne(@PathVariable Long id) {
        return this.categoriaRepository.findById(id)
            .orElseThrow(() -> new CategoriaNotFoundException(id));
    }

    @DeleteMapping("/categorias/{id}")
    void deleteCategoria(@PathVariable Long id) {
        Boolean isUtilizadaPorProduto = this.categoriaRepository.existeProdutoCategoria(id) > 0;
        if (isUtilizadaPorProduto) throw new CategoriaOcupadaException(id);

        if (!this.categoriaRepository.existsById(id)) throw new CategoriaNotFoundException(id);
        this.categoriaRepository.deleteById(id);
    }

    @PostMapping("/categorias")
    Categoria save(@Valid @RequestBody CategoriaDto dto) {
        return this.categoriaRepository.save(dto.toCategoria());
    }

    @PutMapping("/categorias/{id}")
    Categoria updCategoria(@Valid @RequestBody CategoriaDto dto, @PathVariable Long id) {
        return this.categoriaRepository.findById(id)
            .map(c -> {
                c.setDescricao(dto.getDescricao());
                c.setNome(dto.getNome());
                return this.categoriaRepository.save(c);
            })
            .orElseThrow(() -> new CategoriaNotFoundException(id));
    }
    
}
