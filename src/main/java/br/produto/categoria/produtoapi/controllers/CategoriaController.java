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
import br.produto.categoria.produtoapi.services.CategoriaDto;
import br.produto.categoria.produtoapi.services.interfaces.CategoriaService;

@RestController
public class CategoriaController {

    private final CategoriaService service;

    CategoriaController (CategoriaService service) {
        this.service = service;
    }

    @GetMapping("/categorias")
    List<Categoria> all() {
        return this.service.findAll();
    }

    @GetMapping("/categorias/{id}")
    Categoria findOne(@PathVariable Long id) {
        return this.service.findOne(id);
    }

    @DeleteMapping("/categorias/{id}")
    void deleteCategoria(@PathVariable Long id) {
        this.service.deleteCategoria(id);
    }

    @PostMapping("/categorias")
    Categoria save(@Valid @RequestBody CategoriaDto dto) {
        return this.service.save(dto);
    }

    @PutMapping("/categorias/{id}")
    Categoria updCategoria(@Valid @RequestBody CategoriaDto dto, @PathVariable Long id) {
        return this.service.updCategoria(dto, id);
    }
    
}
