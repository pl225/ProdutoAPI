package br.produto.categoria.produtoapi.controllers;

import br.produto.categoria.produtoapi.entities.Categoria;

public class CategoriaDto {

    private String nome;
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
