package br.produto.categoria.produtoapi.services;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import br.produto.categoria.produtoapi.entities.Categoria;
import br.produto.categoria.produtoapi.entities.Produto;

public class ProdutoDto {

    @NotNull(message = "O nome do produto é obrigatório.")
    private String nome;

    @NotNull(message = "O código do produto é obrigatório.")
    private String codigo;

    @NotNull(message = "O valor do produto é obrigatório.")
    @Positive(message = "O valor do produto deve ser maior que zero.")
    private Double valor;

    @NotNull(message = "O identificador da categoria do produto é obrigatório.")
    @Positive(message = "O identificador da categoria do produto deve ser maior que zero.")
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
