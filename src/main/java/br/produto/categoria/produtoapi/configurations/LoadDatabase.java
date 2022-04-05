package br.produto.categoria.produtoapi.configurations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.produto.categoria.produtoapi.entities.Categoria;
import br.produto.categoria.produtoapi.entities.Produto;
import br.produto.categoria.produtoapi.repositories.CategoriaRepository;
import br.produto.categoria.produtoapi.repositories.ProdutoRepository;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(
        ProdutoRepository produtoRepository,
        CategoriaRepository categoriaRepository
    ) {
        return args -> {
            Categoria categoria = new Categoria("Básico", "Itens comuns");
            categoria = categoriaRepository.save(categoria);
            log.info("Carregando " + categoria);

            Produto produto = new Produto("Notebook", "14ff", 3000.0, categoria);
            produto = produtoRepository.save(produto);
            log.info("Carregando " + produto);
        };
    }
    
}
