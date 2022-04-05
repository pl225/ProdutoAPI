package br.produto.categoria.produtoapi.controllers;

import br.produto.categoria.produtoapi.entities.Categoria;
import br.produto.categoria.produtoapi.entities.Produto;

public class ProdutoDto {

    private String nome;
    private String codigo;
    private Double valor;
    private Long categoriaId;
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }
    public Long getCategoriaId() {
        return categoriaId;
    }
    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }
    
    public Produto toProduto(Categoria categoria) {
        return new Produto(nome, codigo, valor, categoria);
    } 

}
