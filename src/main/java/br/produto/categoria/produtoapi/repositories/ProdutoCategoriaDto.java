package br.produto.categoria.produtoapi.repositories;

public class ProdutoCategoriaDto {
    private Long id;
    private String nome;
    private String codigo;
    private Double valor;
    private String categoriaNome;
    private Long categoriaId;
    
    public ProdutoCategoriaDto(Long id, String nome, String codigo, Double valor, Long categoriaId, String categoriaNome) {
        this.id = id;
        this.nome = nome;
        this.codigo = codigo;
        this.valor = valor;
        this.categoriaNome = categoriaNome;
        this.categoriaId = categoriaId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getCategoriaNome() {
        return categoriaNome;
    }

    public void setCategoriaNome(String categoriaNome) {
        this.categoriaNome = categoriaNome;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }

    
    
}
