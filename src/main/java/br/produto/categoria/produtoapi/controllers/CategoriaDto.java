package br.produto.categoria.produtoapi.controllers;

import javax.validation.constraints.NotNull;

import br.produto.categoria.produtoapi.entities.Categoria;

public class CategoriaDto {

    @NotNull(message = "O nome da categoria é obrigatório.")
    private String nome;

    @NotNull(message = "A descrição da categoria é obrigatória.")
    private String descricao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    Categoria toCategoria() {
        return new Categoria(this.nome, this.descricao);
    }
    
}
